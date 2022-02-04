package com.starter.starter_demo.crud.service;

import java.util.List;

import com.starter.starter_demo.crud.models.CustomerFLNameModel;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.RegisterRequestModel;

public interface CustomerService {

	public List<CustomerModel> findAll();
	public List<CustomerFLNameModel> findAllFLName();
	public List<CustomerModel> save(RegisterRequestModel registerRequestModel);
	public List<CustomerModel> update(CustomerModel customerModel);
	public CustomerModel findByCustomerId(Long customerId);
	public CustomerFLNameModel findProjectionOne(Long customerId);
}
