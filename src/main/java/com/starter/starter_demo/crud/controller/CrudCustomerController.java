package com.starter.starter_demo.crud.controller;

import java.util.List;
import java.util.Optional;

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
import com.starter.starter_demo.crud.models.DropdownChoices;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.DeleteCustomerModel;
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.models.SearchQuery;
import com.starter.starter_demo.crud.service.CustomerService;

@RestController
@RequestMapping("/crud/customer")
@CrossOrigin(origins="*", maxAge=3600)
public class CrudCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CrudRepositoryCustomer crudRepositoryCustomer;
	
	/*
	 * Sample Path Variable
	 * 
	 * 	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public List<CustomerFLNameModel> getData(@PathVariable int id) {		
			return customerService.findAll();
		}
	 * */
	
	/*
	 * Search using POST
	 * 
		@RequestMapping(value = "/search", method = RequestMethod.POST)
		public ApiResult searchfindAll(@RequestBody SearchParams searchParams) {		
			return ApiResult.createResponse(customerService.searchFindAll(searchParams), "Token to be added later", "Message to be added later");
		}
	*/
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ApiResult findByCustomerId(
			@RequestParam(value = "searchQuery", required = false, defaultValue = "") String searchQuery,
			@RequestParam(value = "sortDirection", required = false, defaultValue = "dsc") String sortDirection,
			@RequestParam(value = "sortItem", required = false, defaultValue = "firstName") String sortItem,
			@RequestParam(value = "itemsPerPage", required = false, defaultValue = "5") int itemsPerPage,
			@RequestParam(value = "pageInput", required = false, defaultValue = "1") int pageInput) {	
		
		SearchParams searchParams = new SearchParams();
		
		searchParams.setSearchQuery(searchQuery);
		searchParams.setSortDirection(sortDirection);
		searchParams.setSortItem(sortItem);
		searchParams.setItemsPerPage(itemsPerPage);
		searchParams.setPageInput(pageInput);
		
		return ApiResult.createResponse(customerService.searchFindAll(searchParams), "Token to be added later", "Message to be added later");
	}
	
	@RequestMapping(value = "/names", method = RequestMethod.POST)
	public ApiResult findByCustomerName(@RequestBody SearchQuery searchQuery) {		
		return ApiResult.createResponse(customerService.findByCustomerName(searchQuery), "Token to be added later", "Message to be added later");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ApiResult DeleteByCustomerId(@RequestBody DeleteCustomerModel customerId) {		
		return ApiResult.createResponse(customerService.deleteByCustomerId(customerId), "Token to be added later", "Message to be added later");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiResult saveCustomer(@RequestBody CustomerModel customerModel) {
		return ApiResult.createResponse(customerService.saveCustomer(customerModel), "Token to be added later", "Message to be added later");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ApiResult editCustomer(@RequestBody CustomerModel customerModel) {
		return ApiResult.createResponse(customerService.updateCustomer(customerModel), "Token to be added later", "Message to be added later");
	}
	
//	
//	@RequestMapping(value = "/findByCustomerId", method = RequestMethod.GET)
//	public ApiResult findByCustomerId(@RequestParam Long customerId) {			
//		return ApiResult.createResponse(customerService.findByCustomerId(customerId), "Token to be added later", "Message to be added later");		
//	}
	
	@RequestMapping(value = "/findProjectionOne", method = RequestMethod.GET)
	public DropdownChoices findProjectionOne(@RequestParam Long customerId) {			
		return customerService.findProjectionOne(customerId);
	}
	
	@RequestMapping(value = "/findSpecific", method = RequestMethod.GET)
	public Customer findSpecific(@RequestParam Long customerId) {			
		return crudRepositoryCustomer.findSpecific(customerId);
	}
}
