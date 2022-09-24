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
@Table(name="privilege")
@NamedQuery(name="Privilege.findAll", query="SELECT u FROM Privilege u")
public class Privilege {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int privilegeId;
	private String privilegeName;
	
	@OneToMany(mappedBy = "privilege")
	private List<RoleToPrivilege> roleToPrivileges;
	
	public Privilege() {
		
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public List<RoleToPrivilege> getRoleToPrivileges() {
		return roleToPrivileges;
	}

	public void setRoleToPrivileges(List<RoleToPrivilege> roleToPrivileges) {
		this.roleToPrivileges = roleToPrivileges;
	}
}
