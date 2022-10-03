package com.starter.starter_demo.crud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="userr")
@NamedQuery(name="Userr.findAll", query="SELECT u FROM Userr u")
public class Userr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String username;
	private String password;
	private boolean isEnabled;
	private boolean isNotLocked;
	private boolean isAccountNotExpired;
	private boolean isPasswordNotExpired;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@OneToMany(mappedBy = "userr")
	private List<UserToRole> UserToRole;
	
	public Userr() {
		
	}

	public String getUsername() {
		return username;
	}

	public List<UserToRole> getUserToRole() {
		return UserToRole;
	}

	public void setUserToRole(List<UserToRole> userToRole) {
		UserToRole = userToRole;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isNotLocked() {
		return isNotLocked;
	}

	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}

	public boolean isAccountNotExpired() {
		return isAccountNotExpired;
	}

	public void setAccountNotExpired(boolean isAccountNotExpired) {
		this.isAccountNotExpired = isAccountNotExpired;
	}

	public boolean isPasswordNotExpired() {
		return isPasswordNotExpired;
	}

	public void setPasswordNotExpired(boolean isPasswordNotExpired) {
		this.isPasswordNotExpired = isPasswordNotExpired;
	}
}
