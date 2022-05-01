package com.starter.starter_demo.crud.models;

import com.starter.starter_demo.common.projections.ProjectionOne;
import com.starter.starter_demo.crud.entity.Customer;
import com.starter.starter_demo.crud.entity.Promo;
import com.starter.starter_demo.crud.entity.Provider;

public class DropdownChoices {
	
	private String value;
	private String label;
	
	public DropdownChoices() {
		
	}
	
	//use this if no changes in the data during mapping.
	//use this AND setters if there are changes to be made in the data during mapping.
	public DropdownChoices(Customer customerEntity) {
		this.value = customerEntity.getCustomerId();
		this.label = customerEntity.getFirstName() + " " +
				customerEntity.getMiddleName() + " " +
				customerEntity.getLastName();
	}
	
	public DropdownChoices(Promo promoEntity) {
		this.value = promoEntity.getPromoId();
		this.label = promoEntity.getPromoName();
	}
	
	public DropdownChoices(Provider promoEntity) {
		this.value = promoEntity.getProviderId();
		this.label = promoEntity.getProviderName();
	}
	
	public DropdownChoices(ProjectionOne projectionOne) {
//		this.setFirstName(projectionOne.getFirstName());
//		this.setLastName(projectionOne.getLastName());
//		this.setMiddleName(projectionOne.getMiddleName());
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getMiddleName() {
//		return middleName;
//	}
//
//	public void setMiddleName(String middleName) {
//		this.middleName = middleName;
//	}

	
}
