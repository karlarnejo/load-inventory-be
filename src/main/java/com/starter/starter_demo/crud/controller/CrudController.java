package com.starter.starter_demo.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResult;
import com.starter.starter_demo.crud.dao.CrudRepositoryCustomer;
import com.starter.starter_demo.crud.dao.CrudRepositoryOrderline;
import com.starter.starter_demo.crud.entity.Customer;
import com.starter.starter_demo.crud.entity.Orderline;
import com.starter.starter_demo.crud.models.CustomerFLNameModel;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.RegisterRequestModel;
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.service.CustomerService;
import com.starter.starter_demo.crud.service.OrderlineService;

@RestController
@RequestMapping("/crud")
@CrossOrigin(origins="*", maxAge=3600)
public class CrudController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderlineService orderlineService;
	
	@Autowired
	private CrudRepositoryOrderline crudRepositoryOrderline;
	
	@Autowired
	private CrudRepositoryCustomer crudRepositoryCustomer;
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public List<CustomerFLNameModel> getData(@PathVariable int id) {		
//		return customerService.findAll();
//	}
	
//	@RequestMapping(value = "/flname", method = RequestMethod.GET)
//	public ApiResult findAllFLName() {			
//		return ApiResult.createRespose(customerService.findAllFLName(), "Token to be added later", "Message to be added later");		
//	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ApiResult searchfindAll(@RequestBody SearchParams searchParams) {		
		return ApiResult.createRespose(customerService.searchFindAll(searchParams), "Token to be added later", "Message to be added later");
	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ApiResult save(@RequestBody RegisterRequestModel registerRequestModel) {
//		return ApiResult.createRespose(customerService.save(registerRequestModel), "Token to be added later", "Message to be added later");
//	}
//	
//	@RequestMapping(value = "/findByCustomerId", method = RequestMethod.GET)
//	public ApiResult findByCustomerId(@RequestParam Long customerId) {			
//		return ApiResult.createRespose(customerService.findByCustomerId(customerId), "Token to be added later", "Message to be added later");		
//	}
	
	@RequestMapping(value = "/findAllInnerJoin", method = RequestMethod.GET)
	public ApiResult findAllInnerJoin() {		
		return ApiResult.createRespose(orderlineService.findAllInnerJoin(), "Token to be added later", "Message to be added later");
	}
	
	@RequestMapping(value = "/findAllInnerJoinWhere", method = RequestMethod.GET)
	public ApiResult findAllInnerJoinWhere(@RequestParam Long customerId) {			
		return ApiResult.createRespose(orderlineService.findAllInnerJoinWhere(customerId), "Token to be added later", "Message to be added later");		
	}
	
	@RequestMapping(value = "/findProjectionOne", method = RequestMethod.GET)
	public CustomerFLNameModel findProjectionOne(@RequestParam Long customerId) {			
		return customerService.findProjectionOne(customerId);
	}
	
	@RequestMapping(value = "/findSpecific", method = RequestMethod.GET)
	public Customer findSpecific(@RequestParam Long customerId) {			
		return crudRepositoryCustomer.findSpecific(customerId);
	}
}
