package com.starter.starter_demo.crud.models;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.starter.starter_demo.crud.entity.Customer;
import com.starter.starter_demo.crud.entity.Orderline;
import com.starter.starter_demo.crud.entity.Promo;

public class OrderlineModel {

	private String orderlineId;
	private String customerId;
	private String promoId;
	private int status;
	private float price;
	private String number;
	private Date updatedAt;

	public String getOrderlineId() {
		return orderlineId;
	}
	public void setOrderlineId(String orderlineId) {
		this.orderlineId = orderlineId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPromoId() {
		return promoId;
	}
	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Orderline toEntity() {
		Orderline orderlineEntity = new Orderline();
		Customer customerEntity = new Customer();
		Promo promoEntity = new Promo();
		
		customerEntity.setCustomerId(getCustomerId());
		promoEntity.setPromoId(getPromoId());
		
		orderlineEntity.setStatus(this.status);
		orderlineEntity.setNumber(this.number);
		orderlineEntity.setUpdatedAt(this.updatedAt);
		orderlineEntity.setPrice(this.price);
		orderlineEntity.setCustomer(customerEntity);
		orderlineEntity.setPromo(promoEntity);
		
		return orderlineEntity;
	}
	
	public Orderline partialUpdate(Orderline orderlineEntity) {
		Customer customerEntity = new Customer();
		Promo promoEntity = new Promo();
		
		customerEntity.setCustomerId(getCustomerId());
		promoEntity.setPromoId(getPromoId());
		
		orderlineEntity.setOrderlineId(this.orderlineId);
		orderlineEntity.setStatus(this.status);
		orderlineEntity.setNumber(this.number);
		orderlineEntity.setPrice(this.price);
		orderlineEntity.setUpdatedAt(this.updatedAt);
		orderlineEntity.setCustomer(customerEntity);
		orderlineEntity.setPromo(promoEntity);
		
		return orderlineEntity;
	}
}
