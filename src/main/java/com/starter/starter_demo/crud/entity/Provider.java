package com.starter.starter_demo.crud.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="provider")
@NamedQuery(name="Provider.findAll", query="SELECT p FROM Provider p")
public class Provider {

	private static final long serialVersionUID = 1L;

	@Id
	private String providerId;
	private String providerName;
	private boolean active;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@OneToMany(mappedBy = "provider")
	private List<Promo> promo;
	
	public Provider() {
		
	}
	
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
	public List<Promo> getPromo() {
		return promo;
	}
	public void setPromo(List<Promo> promo) {
		this.promo = promo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
