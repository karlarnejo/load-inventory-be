package com.starter.starter_demo.crud.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.starter_demo.crud.dao.CrudRepositoryUser;
import com.starter.starter_demo.crud.entity.RoleToPrivilege;
import com.starter.starter_demo.crud.entity.UserToRole;
import com.starter.starter_demo.crud.entity.Userr;
import com.starter.starter_demo.crud.models.LoginRequest;
import com.starter.starter_demo.crud.models.UserToRoleModel;
import com.starter.starter_demo.crud.models.UserrJwtModel;
import com.starter.starter_demo.exception.UserAccountDisabledException;
import com.starter.starter_demo.exception.UserAccountExpiredException;
import com.starter.starter_demo.exception.UserAccountLockedException;
import com.starter.starter_demo.exception.UserInvalidPasswordException;
import com.starter.starter_demo.exception.UserInvalidUsernameException;
import com.starter.starter_demo.exception.UserPasswordExpiredException;

@Transactional
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CrudRepositoryUser crudRepositoryUser;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
						
		UserrJwtModel response = new UserrJwtModel(crudRepositoryUser.findByUsername(username));

		if (!response.getUsername().equals("")) {

			logger.debug("There is a username found {}.", response.getUsername());
			
			/* 
			 * User(...) auto decrypts the password supplied in UsernamePasswordAuthenticationToken(), 
			 * check if they are a match. PW in DB should be in BCrypt
			 */
			
			Set<GrantedAuthority> authorities = new HashSet<>();
			
			for (UserToRole userToRole : response.getUserToRole()) {
				logger.debug("Roles found for {} are: {}.", response.getUsername(), userToRole.getRole().getRoleName());
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getRole().getRoleName()));
	            for (RoleToPrivilege userRoleToRolePrivileges : userToRole.getRole().getRoleToPrivileges()) {
					logger.debug("Privileges found for {} are: {}.", response.getUsername(), userRoleToRolePrivileges.getPrivilege().getPrivilegeName());
	                authorities.add(new SimpleGrantedAuthority(userRoleToRolePrivileges.getPrivilege().getPrivilegeName()));
	            }
	        }
			
	       return new LoginRequest(response.getUsername(), response.getPassword(), response.isEnabled(), response.isNotLocked(), response.isAccountNotExpired(), response.isPasswordNotExpired(), authorities);
		} 
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e) {
			throw new UserAccountDisabledException();
		}catch (LockedException e) {
			throw new UserAccountLockedException();
		}catch (AccountExpiredException e) {
			throw new UserAccountExpiredException();
		}catch (CredentialsExpiredException e) {
			throw new UserPasswordExpiredException();
		}catch (InternalAuthenticationServiceException e) {
			throw new UserInvalidUsernameException();
		}catch (BadCredentialsException e) {
			throw new UserInvalidPasswordException();
		}
	}
}