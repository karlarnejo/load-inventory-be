package com.starter.starter_demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResult;
import com.starter.starter_demo.crud.dao.CrudRepositoryOrderline;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.DeleteCustomerModel;
import com.starter.starter_demo.crud.models.DeleteOrderModel;
import com.starter.starter_demo.crud.models.OrderlineModel;
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.service.OrderlineService;

@RestController
@RequestMapping("/crud/orderline")
@CrossOrigin(origins="*", maxAge=3600)
public class CrudOrderlineController {
	
	@Autowired
	private OrderlineService orderlineService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ApiResult searchfindAll(@RequestBody SearchParams searchParams) {		
		return ApiResult.createResponse(orderlineService.searchFindAll(searchParams), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ApiResult DeleteByCustomerId(@RequestBody DeleteOrderModel orderlineId) {		
		return ApiResult.createResponse(orderlineService.deleteByOrderlineId(orderlineId), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiResult saveCustomer(@RequestBody OrderlineModel orderlineModel) {
		return ApiResult.createResponse(orderlineService.saveOrderline(orderlineModel), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ApiResult editCustomer(@RequestBody OrderlineModel orderlineModel) {
		return ApiResult.createResponse(orderlineService.updateOrderline(orderlineModel), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
//	@RequestMapping(value = "/findAllInnerJoinWhere", method = RequestMethod.GET)
//	public ApiResult findAllInnerJoinWhere(@RequestParam Long customerId) {			
//		return ApiResult.createResponse(orderlineService.findAllInnerJoinWhere(customerId), "CUSTOM_SUCCESS_STATUS", "Message to be added later");		
//	}
}
