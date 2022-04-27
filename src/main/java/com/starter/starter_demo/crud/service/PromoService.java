package com.starter.starter_demo.crud.service;

import java.util.List;

import com.starter.starter_demo.crud.models.DropdownChoices;
import com.starter.starter_demo.crud.models.SearchQuery;

public interface PromoService {
	public List<DropdownChoices> findByPromoName(SearchQuery searchQuery);
}
