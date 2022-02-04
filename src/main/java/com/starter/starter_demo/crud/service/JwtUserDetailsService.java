package com.starter.starter_demo.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.starter.starter_demo.crud.dao.CrudRepositoryUser;
import com.starter.starter_demo.crud.models.LoginRequest;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CrudRepositoryUser crudRepositoryUser;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginRequest response = new LoginRequest(crudRepositoryUser.findByUsername(username));
		
		if (!response.getUsername().equals("")) {
			/* 
			 * User(...) auto decrypts the password supplied in UsernamePasswordAuthenticationToken(), 
			 * check if they are a match. PW in DB should be in BCrypt
			 */
			return new User(response.getUsername(), response.getPassword(),
				new ArrayList<>());
		} 
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}