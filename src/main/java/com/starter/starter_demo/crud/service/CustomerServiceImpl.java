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
import com.starter.starter_demo.crud.entity.Customer;
import com.starter.starter_demo.crud.models.CustomerFLNameModel;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.PaginationModel;
import com.starter.starter_demo.crud.models.RegisterRequestModel;
import com.starter.starter_demo.crud.models.SearchParams;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CrudRepositoryCustomer crudRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
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

//	@Override
//	public List<CustomerModel> findAll() {
//		// TODO Auto-generated method stub
//		
//		List<CustomerModel> customerModel = new ArrayList<CustomerModel>();
//
//		Pageable pageable = PageRequest.of(0, 10);
//
//		crudRepository.findAll(pageable).forEach(data -> {
//			CustomerModel tempModel = new CustomerModel(data);
//			
//			customerModel.add(tempModel);
//		});
//		
//		return customerModel;
//	}
	
	@Override
//	public List<PaginationModel> findAll(Pageable pageable) {
	public PaginationModel findAll(SearchParams searchParams) {
		// TODO Auto-generated method stub
		
		PaginationModel paginationModel = new PaginationModel();
		List<CustomerModel> customerModel = new ArrayList<CustomerModel>();

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
		findAllCustomers = crudRepository.findAll(paging);
		
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

//	@Override
//	public List<CustomerModel> save(RegisterRequestModel registerRequestModel) {
//		// TODO Auto-generated method stub
//		
//		RegisterRequestModel toSave = registerRequestModel;
//		
//		crudRepository.saveAndFlush(toSave.toEntity());
//		
//		return findAll();
//	}

//	@Override
//	public List<CustomerModel> update(CustomerModel customerModel) {
//		// TODO Auto-generated method stub
//		
//		crudRepository.saveAndFlush(customerModel.toEntity());
//		
//		return null;
//	}

//	@Override
//	public CustomerModel findByCustomerId(Long customerId) {
//		// TODO Auto-generated method stub
//		
//		CustomerModel customerModel = new CustomerModel(crudRepository.findByCustomerId(customerId));
//		
//		return customerModel;
//	}

	@Override
	public CustomerFLNameModel findProjectionOne(Long customerId) {
		// TODO Auto-generated method stub
		CustomerFLNameModel customerFLNameModel = new CustomerFLNameModel(crudRepository.findProjectionOne(customerId));
		
		return customerFLNameModel;
	}
}
