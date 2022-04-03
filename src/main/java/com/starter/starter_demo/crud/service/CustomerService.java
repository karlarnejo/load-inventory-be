package com.starter.starter_demo.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.starter.starter_demo.crud.models.CustomerFLNameModel;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.PaginationModel;
import com.starter.starter_demo.crud.models.RegisterRequestModel;
import com.starter.starter_demo.crud.models.SearchParams;

public interface CustomerService {

	public PaginationModel searchFindAll(SearchParams searchParams);
	
//	public List<CustomerFLNameModel> findAllFLName();
//	public List<CustomerModel> save(RegisterRequestModel registerRequestModel);
//	public List<CustomerModel> update(CustomerModel customerModel);
//	public CustomerModel findByCustomerId(Long customerId);
	public CustomerFLNameModel findProjectionOne(Long customerId);	
}
