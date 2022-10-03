package com.starter.starter_demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResult;
import com.starter.starter_demo.crud.models.SearchQuery;
import com.starter.starter_demo.crud.service.ProviderService;

@RestController
@RequestMapping("/crud/provider")
@CrossOrigin(origins="*", maxAge=3600)
public class CrudProviderController {

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value = "/names", method = RequestMethod.POST)
	public ApiResult findByProviderName(@RequestBody SearchQuery searchQuery) {		
		return ApiResult.createResponse(providerService.findByProviderName(searchQuery), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
}
