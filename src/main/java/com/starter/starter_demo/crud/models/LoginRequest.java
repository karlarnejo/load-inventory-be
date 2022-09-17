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
	private boolean active;
	private Collection<? extends GrantedAuthority> authorities;

	public LoginRequest() {

	}
	
	public LoginRequest(Userr userEntity) {
		this.setUsername(userEntity.getUsername());
		this.setPassword(userEntity.getPassword());
	}

	public LoginRequest(String username, String password, boolean active,
			Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.active = active;
		this.authorities = authorities;
	}

	public LoginRequest buildUser(String username, String password, boolean active,
			Collection<? extends GrantedAuthority> authorities) {
		return new LoginRequest(username, password, active, authorities);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
