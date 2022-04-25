package com.starter.starter_demo.crud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="promo")
@NamedQuery(name="Promo.findAll", query="SELECT p FROM Promo p")
public class Promo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String promoId;
	private String promoName;
	private boolean inStock;
	private String price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@OneToMany(mappedBy = "promo")
	private List<Orderline> orderLine;
	
	@ManyToOne
	@JoinColumn(name = "providerId", referencedColumnName = "providerId")
	private Provider provider;
			
	public Promo() {
		
	}

	public String getPromoId() {
		return promoId;
	}

	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public List<Orderline> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<Orderline> orderLine) {
		this.orderLine = orderLine;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
