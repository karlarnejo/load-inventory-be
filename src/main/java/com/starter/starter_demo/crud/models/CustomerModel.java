package com.starter.starter_demo.crud.models;

import com.starter.starter_demo.crud.entity.Customer;

public class CustomerModel {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private String contactNo;
	private String address;
	
	public CustomerModel() {
		
	}
	
	//use this if no changes in the data during mapping.
	//use this AND setters if there are changes to be made in the data during mapping.
	public CustomerModel(Customer customerEntity) {
		this.setFirstName(customerEntity.getFirstName());
		this.setLastName(customerEntity.getLastName());
		this.setMiddleName(customerEntity.getMiddleName());
		this.setCustomerId(customerEntity.getCustomerId());
		this.setGender(customerEntity.getGender());
		this.setContactNo(customerEntity.getContactNo());
		this.setAddress(customerEntity.getAddress());
	}
	
	public Customer toEntity() {
		Customer customerEntity = new Customer();
		
		customerEntity.setFirstName(this.firstName);
		customerEntity.setLastName(this.lastName);
		customerEntity.setMiddleName(this.middleName);
		customerEntity.setCustomerId(this.customerId);
		customerEntity.setGender(this.gender);
		customerEntity.setContactNo(this.contactNo);
		customerEntity.setAddress(this.address);
		
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
