package com.starter.starter_demo.crud.service;

import java.util.List;

import com.starter.starter_demo.crud.models.OrderlineCustomerModel;

public interface OrderlineService {
	public List<OrderlineCustomerModel> findAllInnerJoin();
	public OrderlineCustomerModel findAllInnerJoinWhere(Long customerId);
}
