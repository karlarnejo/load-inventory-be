package com.starter.starter_demo.crud.models;

import java.util.List;

import com.starter.starter_demo.crud.entity.RoleToPrivilege;
import com.starter.starter_demo.crud.entity.UserToRole;

public class UserToRoleModel {

	private String roleName;
	private List<RoleToPrivilege> userRoleToRolePrivileges;
	private List<UserToRole> userToRole;
	
	public UserToRoleModel() {
		
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public List<RoleToPrivilege> getUserRoleToRolePrivileges() {
		return userRoleToRolePrivileges;
	}

	public void setUserRoleToRolePrivileges(List<RoleToPrivilege> userRoleToRolePrivileges) {
		this.userRoleToRolePrivileges = userRoleToRolePrivileges;
	}

	public List<UserToRole> getUserToRole() {
		return userToRole;
	}

	public void setUserToRole(List<UserToRole> userToRole) {
		this.userToRole = userToRole;
	}
}
