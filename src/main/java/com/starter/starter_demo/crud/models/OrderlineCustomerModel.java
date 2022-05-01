package com.starter.starter_demo.crud.models;

import java.util.Date;

import com.starter.starter_demo.crud.entity.Orderline;

public class OrderlineCustomerModel {
	private String orderlineId;
	private String name;
	private String orderCode;
	private Date createdAt;
	private Date updatedAt;
	private String number;
	private String promoName;
	private float price;
	private String providerName;
	private String customerId;
	private int status;
	private String promoId;
	private String statusMeaning;
	
	public OrderlineCustomerModel() {
		
	}
	
	public OrderlineCustomerModel(Orderline orderlineEntity) {
		this.orderlineId = orderlineEntity.getOrderlineId();
		this.name = orderlineEntity.getCustomer().getFirstName() + " " +
				orderlineEntity.getCustomer().getMiddleName() + " " +
				orderlineEntity.getCustomer().getLastName();
		this.orderCode = orderlineEntity.getOrderCode();
		this.createdAt = orderlineEntity.getCreatedAt();
		this.updatedAt = orderlineEntity.getUpdatedAt();
		this.promoName = orderlineEntity.getPromo().getPromoName();
		this.price = orderlineEntity.getPrice();
		this.providerName = orderlineEntity.getPromo().getProvider().getProviderName();
		this.customerId = orderlineEntity.getCustomer().getCustomerId();
		this.status = orderlineEntity.getStatus();
		this.number = orderlineEntity.getNumber();
		this.promoId = orderlineEntity.getPromo().getPromoId();
		this.statusMeaning = statusMeaning(orderlineEntity.getStatus());
	}
	
	private String statusMeaning(int statusParam) {
		if(statusParam == 1) {
			return "Completed";
		}
		else if(statusParam == 2) {
			return "Ongoing";
		}
		else {
			return "Failed";
		}
	};

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPromoId() {
		return promoId;
	}

	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}

	public String getStatusMeaning() {
		return statusMeaning;
	}

	public void setStatusMeaning(String statusMeaning) {
		this.statusMeaning = statusMeaning;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
