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
	private String orderCode;
	/* 
	 * Just so createdAt is not blank on update
	 * Replace this later using triggers in postgresql.
	 * 
	 * */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	private int status;
	private float discount;
	private String number;
	private Date updatedAt;
	
	public String getOrderlineId() {
		return orderlineId;
	}
	public void setOrderlineId(String orderlineId) {
		this.orderlineId = orderlineId;
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
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
		
		orderlineEntity.setOrderlineId(this.orderlineId);
		orderlineEntity.setOrderCode(this.orderCode);
		orderlineEntity.setStatus(this.status);
		orderlineEntity.setNumber(this.number);
		orderlineEntity.setDiscount(this.discount);
		orderlineEntity.setCreatedAt(this.createdAt);
		orderlineEntity.setUpdatedAt(this.updatedAt);
		orderlineEntity.setCustomer(customerEntity);
		orderlineEntity.setPromo(promoEntity);
		
		return orderlineEntity;
	}
}
