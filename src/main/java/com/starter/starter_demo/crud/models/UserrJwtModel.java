package com.starter.starter_demo.crud.models;

import java.util.List;

import com.starter.starter_demo.crud.entity.UserToRole;
import com.starter.starter_demo.crud.entity.Userr;

public class UserrJwtModel {
	
	private String username;
	private String password;
	private boolean isEnabled;
	private List<UserToRole> userToRole;
	
	public UserrJwtModel() {
		
	}
	
	public UserrJwtModel(Userr userr) {
		this.setUsername(userr.getUsername());
		this.setPassword(userr.getPassword());
		this.setEnabled(userr.isEnabled());
		this.setUserToRole(userr.getUserToRole());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<UserToRole> getUserToRole() {
		return userToRole;
	}

	public void setUserToRole(List<UserToRole> userToRole) {
		this.userToRole = userToRole;
	}
}
