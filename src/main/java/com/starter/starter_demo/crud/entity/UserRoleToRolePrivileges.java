package com.starter.starter_demo.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="userroletoroleprivileges")
@NamedQuery(name="UserRoleToRolePrivileges.findAll", query="SELECT u FROM UserRoleToRolePrivileges u")
public class UserRoleToRolePrivileges {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleToRolePrivilegesId;
	
	@ManyToOne
	@JoinColumn(name = "userRoleId", referencedColumnName = "userRoleId")
    private UserRole userRolePriv;
	
    @ManyToOne
    @JoinColumn(name = "userPrivilegesId", referencedColumnName = "userPrivilegesId")
    private UserPrivileges userPrivileges;
    
    public UserRoleToRolePrivileges() {
    	
    }
    
    
	public int getUserRoleToRolePrivilegesId() {
		return userRoleToRolePrivilegesId;
	}
	public void setUserRoleToRolePrivilegesId(int userRoleToRolePrivilegesId) {
		this.userRoleToRolePrivilegesId = userRoleToRolePrivilegesId;
	}
	public UserRole getUserRolePriv() {
		return userRolePriv;
	}
	public void setUserRolePriv(UserRole userRolePriv) {
		this.userRolePriv = userRolePriv;
	}
	public UserPrivileges getUserPrivileges() {
		return userPrivileges;
	}
	public void setUserPrivileges(UserPrivileges userPrivileges) {
		this.userPrivileges = userPrivileges;
	}
}
