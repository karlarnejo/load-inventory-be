package com.starter.starter_demo.crud.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="userprivileges")
@NamedQuery(name="UserPrivileges.findAll", query="SELECT u FROM UserPrivileges u")
public class UserPrivileges {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPrivilegesId;
	private String privilegeName;
	
	@OneToMany(mappedBy = "userPrivileges")
	private List<UserRoleToRolePrivileges> userRoleToRolePrivileges;
	
	public UserPrivileges() {
		
	}

	public int getUserPrivilegesId() {
		return userPrivilegesId;
	}

	public void setUserPrivilegesId(int userPrivilegesId) {
		this.userPrivilegesId = userPrivilegesId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
}
