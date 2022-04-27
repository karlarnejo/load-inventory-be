package com.starter.starter_demo.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.starter.starter_demo.crud.models.DropdownChoices;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.DeleteCustomerModel;
import com.starter.starter_demo.crud.models.PaginationModel;
import com.starter.starter_demo.crud.models.RegisterRequestModel;
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.models.SearchQuery;

public interface CustomerService {

	public PaginationModel searchFindAll(SearchParams searchParams);
	public List<DropdownChoices> findByCustomerName(SearchQuery searchQuery);
	public Void deleteByCustomerId(DeleteCustomerModel customerId);
	public Void updateCustomer(CustomerModel customerModel);
//	public CustomerModel findByCustomerId(Long customerId);
	public DropdownChoices findProjectionOne(Long customerId);	
	public Void saveCustomer(CustomerModel customerModel);
}
