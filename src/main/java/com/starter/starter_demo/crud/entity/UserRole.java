package com.starter.starter_demo.crud.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userrole")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole {
	
	@Id
	private int userRoleId;
	private String roleName;
	
	@OneToMany(mappedBy = "userRole")
	private List<UserToRole> userToRole;
	
	@OneToMany(mappedBy = "userRolePriv")
	private List<UserRoleToRolePrivileges> userRoleToRolePrivileges;
	
	public UserRole() {
		
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public List<UserRoleToRolePrivileges> getUserRoleToRolePrivileges() {
		return userRoleToRolePrivileges;
	}

	public void setUserRoleToRolePrivileges(List<UserRoleToRolePrivileges> userRoleToRolePrivileges) {
		this.userRoleToRolePrivileges = userRoleToRolePrivileges;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserToRole> getUserToRole() {
		return userToRole;
	}

	public void setUserToRole(List<UserToRole> userToRole) {
		this.userToRole = userToRole;
	}
}
