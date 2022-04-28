package com.starter.starter_demo.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.starter_demo.crud.dao.CrudRepositoryCustomer;
//import com.starter.starter_demo.crud.dao.Di;
import com.starter.starter_demo.crud.entity.Customer;
import com.starter.starter_demo.crud.models.DropdownChoices;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.DeleteCustomerModel;
import com.starter.starter_demo.crud.models.PaginationModel;
import com.starter.starter_demo.crud.models.RegisterRequestModel;
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.models.SearchQuery;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CrudRepositoryCustomer crudRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
//	@Autowired
//	private Di di;
	
//	@Override
//	public List<CustomerFLNameModel> findAllFLName() {
//		// TODO Auto-generated method stub
//		
//		List<CustomerFLNameModel> customerModel = new ArrayList<CustomerFLNameModel>();
//		
//		crudRepository.findAll().forEach(data -> {
//			CustomerFLNameModel tempModel = new CustomerFLNameModel(data);
//			
//			customerModel.add(tempModel);
//		});
//		
//		return customerModel;
//	}
	
	@Override
	public PaginationModel searchFindAll(SearchParams searchParams) {
		// TODO Auto-generated method stub
		
		PaginationModel paginationModel = new PaginationModel();
		List<Object> customerModel = new ArrayList<Object>();

		/*
		 * of(page, itemsPerPage) 
		 * page is represented as index (starts with 0) instead of the usual
		 * slice start and slice end in MarkLogic.
		 * */
		int page = (searchParams.getPageInput()-1);
		int itemsPerPage = searchParams.getItemsPerPage();
		
		Sort sort = searchParams.getSortDirection().equals("Ascending") ? Sort.by(searchParams.getSortItem()).ascending() :
			Sort.by(searchParams.getSortItem()).descending();
		
		Pageable paging = PageRequest.of(page, itemsPerPage, sort);
		Page<Customer> findAllCustomers;		
		findAllCustomers = crudRepository.searchFindAll(paging, searchParams.getSearchQuery());
		
		findAllCustomers.getContent().forEach(data -> {
			CustomerModel customerModelTemp = new CustomerModel(data);
			customerModel.add(customerModelTemp);
		});
				
		paginationModel.setData(customerModel);
		paginationModel.setItemsPerPage(findAllCustomers.getSize());
		paginationModel.setPageInput(findAllCustomers.getPageable().getPageNumber());
		paginationModel.setTotalPages(findAllCustomers.getTotalPages());
		
		return paginationModel;
	}
	
	@Override
	public List<DropdownChoices> findByCustomerName(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		List<DropdownChoices> dropdownChoices = new ArrayList<DropdownChoices>();
		
		if(!searchQuery.getSearchQuery().equals("")) {
			crudRepository.findByCustomerName(searchQuery.getSearchQuery()).forEach(data -> {
				DropdownChoices tempModel = new DropdownChoices(data);
				
				dropdownChoices.add(tempModel);
			});
		}
		
		return dropdownChoices;		
	}
	
	@Override
	public Void deleteByCustomerId(DeleteCustomerModel customerId) {
		crudRepository.deleteByCustomerId(customerId.getCustomerId());
		
		return null;
	}
	
	@Override
	public Void saveCustomer(CustomerModel customerModel) {
		
		//TODO: generate primary key
		
		customerModel.setCustomerId("sample1");
		crudRepository.saveAndFlush(customerModel.toEntity());
		
		return null;
	}

	@Override
	public Void updateCustomer(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		Customer customer = crudRepository.findByCustomerId(customerModel.getCustomerId());
		
		crudRepository.saveAndFlush(customerModel.partialUpdate(customer));
		
		return null;
	}

//	@Override
//	public CustomerModel findByCustomerId(Long customerId) {
//		// TODO Auto-generated method stub
//		
//		CustomerModel customerModel = new CustomerModel(crudRepository.findByCustomerId(customerId));
//		
//		return customerModel;
//	}

	//An example using projection.
	@Override
	public DropdownChoices findProjectionOne(Long customerId) {
		// TODO Auto-generated method stub
		DropdownChoices customerFLNameModel = new DropdownChoices(crudRepository.findProjectionOne(customerId));
		
		return customerFLNameModel;
	}
}
