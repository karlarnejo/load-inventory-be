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
import com.starter.starter_demo.crud.models.SearchParams;
import com.starter.starter_demo.crud.service.OrderlineService;

@RestController
@RequestMapping("/crud/orderline")
@CrossOrigin(origins="*", maxAge=3600)
public class CrudOrderlineController {
	
	@Autowired
	private OrderlineService orderlineService;
	
	@RequestMapping(value = "/findAllInnerJoin", method = RequestMethod.POST)
	public ApiResult searchfindAll(@RequestBody SearchParams searchParams) {		
		return ApiResult.createResponse(orderlineService.searchFindAll(searchParams), "Token to be added later", "Message to be added later");
	}
	
//	@RequestMapping(value = "/findAllInnerJoinWhere", method = RequestMethod.GET)
//	public ApiResult findAllInnerJoinWhere(@RequestParam Long customerId) {			
//		return ApiResult.createResponse(orderlineService.findAllInnerJoinWhere(customerId), "Token to be added later", "Message to be added later");		
//	}
}
