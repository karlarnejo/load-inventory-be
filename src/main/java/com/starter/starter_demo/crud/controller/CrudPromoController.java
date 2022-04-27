package com.starter.starter_demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResult;
import com.starter.starter_demo.crud.models.SearchQuery;
import com.starter.starter_demo.crud.service.PromoService;

@RestController
@RequestMapping("/crud/promo")
@CrossOrigin(origins="*", maxAge=3600)
public class CrudPromoController {

	@Autowired
	private PromoService promoService;
	
	@RequestMapping(value = "/names", method = RequestMethod.POST)
	public ApiResult findByPromoName(@RequestBody SearchQuery searchQuery) {		
		return ApiResult.createResponse(promoService.findByPromoName(searchQuery), "Token to be added later", "Message to be added later");
	}
}
