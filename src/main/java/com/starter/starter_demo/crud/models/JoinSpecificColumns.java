package com.starter.starter_demo.crud.models;

import java.util.Date;

import com.starter.starter_demo.crud.entity.Orderline;

public class JoinSpecificColumns {
	private String firstName;
	private String lastName;
	private String middleName;
	private String orderCode;
	private int status;
	private Date orderDate;
	
	public JoinSpecificColumns() {
		
	}
	
	public JoinSpecificColumns(Orderline orderlineEntity) {
		this.firstName = orderlineEntity.getCustomer().getFirstName();
		this.lastName = orderlineEntity.getCustomer().getLastName();
		this.middleName = orderlineEntity.getCustomer().getMiddleName();
		this.orderCode = orderlineEntity.getOrderCode();
		this.status = orderlineEntity.getStatus();
		this.orderDate = orderlineEntity.getOrderDate();
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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
