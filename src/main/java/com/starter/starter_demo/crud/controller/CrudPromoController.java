package com.starter.starter_demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.starter_demo.common.ApiResultRest;
import com.starter.starter_demo.crud.models.SearchQuery;
import com.starter.starter_demo.crud.service.PromoService;

@RestController
@RequestMapping("/crud/promo")
@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
public class CrudPromoController {

	@Autowired
	private PromoService promoService;
	
	@RequestMapping(value = "/names", method = RequestMethod.POST)
	public ApiResultRest findByPromoName(@RequestBody SearchQuery searchQuery) {		
		return ApiResultRest.createResponse(promoService.findByPromoName(searchQuery), "CUSTOM_SUCCESS_STATUS", "Message to be added later");
	}
}
