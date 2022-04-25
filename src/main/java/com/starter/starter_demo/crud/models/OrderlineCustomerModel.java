package com.starter.starter_demo.crud.models;

import java.util.Date;

import com.starter.starter_demo.crud.entity.Orderline;

public class OrderlineCustomerModel {
	private String orderlineId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String fullName;
	private String orderCode;
	private Date createdAt;
	private String promoName;
	private String price;
	private String providerName;
	private int status;
	
	public OrderlineCustomerModel() {
		
	}
	
	public OrderlineCustomerModel(Orderline orderlineEntity) {
		this.orderlineId = orderlineEntity.getOrderlineId();
		this.firstName = orderlineEntity.getCustomer().getFirstName();
		this.lastName = orderlineEntity.getCustomer().getLastName();
		this.middleName = orderlineEntity.getCustomer().getMiddleName();
		this.fullName = orderlineEntity.getCustomer().getFirstName() +
				orderlineEntity.getCustomer().getMiddleName() +
				orderlineEntity.getCustomer().getLastName();
		this.orderCode = orderlineEntity.getOrderCode();
		this.createdAt = orderlineEntity.getCreatedAt();
		this.promoName = orderlineEntity.getPromo().getPromoName();
		this.price = orderlineEntity.getPromo().getPrice();
		this.providerName = orderlineEntity.getPromo().getProvider().getProviderName();
		this.status = orderlineEntity.getStatus();
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(String orderlineId) {
		this.orderlineId = orderlineId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
