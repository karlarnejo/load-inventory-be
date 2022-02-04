package com.starter.starter_demo.crud.models;

import com.starter.starter_demo.crud.entity.Customer;

public class RegisterRequestModel {
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	
	public RegisterRequestModel() {
		
	}
	
	//use this if no changes in the data during mapping.
	//use this AND setters if there are changes to be made in the data during mapping.
	public RegisterRequestModel(Customer customerEntity) {
		this.setFirstName(customerEntity.getFirstName());
		this.setLastName(customerEntity.getLastName());
		this.setMiddleName(customerEntity.getMiddleName());
	}
	
	public Customer toEntity() {
		Customer customerEntity = new Customer();
		
		customerEntity.setFirstName(this.firstName);
		customerEntity.setLastName(this.lastName);
		customerEntity.setMiddleName(this.middleName);
		
		return customerEntity;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
