package com.starter.starter_demo.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.starter_demo.crud.dao.CrudRepositoryOrderline;
import com.starter.starter_demo.crud.models.OrderlineCustomerModel;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderlineServiceImpl implements OrderlineService {

	@Autowired
	private CrudRepositoryOrderline crudRepositoryOrderline;
	
	@Override
	public List<OrderlineCustomerModel> findAllInnerJoin() {
		// TODO Auto-generated method stub
		
		List<OrderlineCustomerModel> orderlineCustomerModelList = new ArrayList<OrderlineCustomerModel>();
		
		crudRepositoryOrderline.findAllInnerJoin().forEach(data -> {
			OrderlineCustomerModel orderlineCustomerModel = new OrderlineCustomerModel(data);
			
			orderlineCustomerModelList.add(orderlineCustomerModel);
		});
		
		return orderlineCustomerModelList;
	}

	@Override
	public OrderlineCustomerModel findAllInnerJoinWhere(Long customerId) {
		// TODO Auto-generated method stub
		
		OrderlineCustomerModel orderlineCustomerModel = new OrderlineCustomerModel(crudRepositoryOrderline.findAllInnerJoinWhere(customerId));

		return orderlineCustomerModel;
	}
}
