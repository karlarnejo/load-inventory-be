package com.starter.starter_demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResultRest;
import com.starter.starter_demo.crud.models.DeleteOrderModel;
import com.starter.starter_demo.crud.models.OrderlineModel;
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.service.OrderlineService;

@RestController
@RequestMapping("/crud/orderline")
@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
public class CrudOrderlineController {
	
	@Autowired
	private OrderlineService orderlineService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ApiResultRest searchfindAll(@RequestBody SearchParams searchParams) {		
		return ApiResultRest.createResponse(orderlineService.searchFindAll(searchParams), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ApiResultRest DeleteByCustomerId(@RequestBody DeleteOrderModel orderlineId) {		
		return ApiResultRest.createResponse(orderlineService.deleteByOrderlineId(orderlineId), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiResultRest saveCustomer(@RequestBody OrderlineModel orderlineModel) {
		return ApiResultRest.createResponse(orderlineService.saveOrderline(orderlineModel), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ApiResultRest editCustomer(@RequestBody OrderlineModel orderlineModel) {
		return ApiResultRest.createResponse(orderlineService.updateOrderline(orderlineModel), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
	
//	@RequestMapping(value = "/findAllInnerJoinWhere", method = RequestMethod.GET)
//	public ApiResult findAllInnerJoinWhere(@RequestParam Long customerId) {			
//		return ApiResult.createResponse(orderlineService.findAllInnerJoinWhere(customerId), "CUSTOM_SUCCESS_STATUS", "Message to be added later");		
//	}
}
