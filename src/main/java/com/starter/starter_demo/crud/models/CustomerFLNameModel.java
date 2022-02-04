package com.starter.starter_demo.crud.models;

import com.starter.starter_demo.common.projections.ProjectionOne;
import com.starter.starter_demo.crud.entity.Customer;

public class CustomerFLNameModel {
	private String firstName;
	private String lastName;
	
	public CustomerFLNameModel() {
		
	}
	
	//use this if no changes in the data during mapping.
	//use this AND setters if there are changes to be made in the data during mapping.
	public CustomerFLNameModel(Customer customerEntity) {
		this.setFirstName(customerEntity.getFirstName());
		this.setLastName(customerEntity.getLastName());
	}
	
	public CustomerFLNameModel(ProjectionOne projectionOne) {
		this.setFirstName(projectionOne.getFirstName());
		this.setLastName(projectionOne.getLastName());
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
