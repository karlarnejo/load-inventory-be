package com.starter.starter_demo.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.starter_demo.crud.dao.CrudRepositoryProvider;
import com.starter.starter_demo.crud.models.DropdownChoices;
import com.starter.starter_demo.crud.models.SearchQuery;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private CrudRepositoryProvider crudRepositoryProvider;
	
	@Override
	public List<DropdownChoices> findByProviderName(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		List<DropdownChoices> dropdownChoices = new ArrayList<DropdownChoices>();
		
		if(!searchQuery.getSearchQuery().equals("")) {
			crudRepositoryProvider.findByProviderName(searchQuery.getSearchQuery()).forEach(data -> {
				DropdownChoices tempModel = new DropdownChoices(data);
				
				dropdownChoices.add(tempModel);
			});
		}
		
		return dropdownChoices;		
	}

}
