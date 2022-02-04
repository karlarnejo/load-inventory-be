package com.starter.starter_demo.crud.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.starter.starter_demo.crud.entity.Userr;

@Service
public class LoginRequest implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public LoginRequest() {
		
	}
	
	public LoginRequest(Userr userEntity) {
		this.setUsername(userEntity.getUsername());
		this.setPassword(userEntity.getPassword());
	}
	
	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public LoginRequest buildUser(String username, String password) {
		return new LoginRequest(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
