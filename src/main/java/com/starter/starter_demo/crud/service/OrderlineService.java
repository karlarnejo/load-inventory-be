package com.starter.starter_demo.crud.service;

import com.starter.starter_demo.crud.models.DeleteOrderModel;
import com.starter.starter_demo.crud.models.OrderlineModel;
import com.starter.starter_demo.crud.models.PaginationModel;
import com.starter.starter_demo.crud.models.SearchParams;

public interface OrderlineService {
//	public OrderlineCustomerModel findAllInnerJoinWhere(Long customerId);
	public PaginationModel searchFindAll(SearchParams searchParams);
	public Void deleteByOrderlineId(DeleteOrderModel orderlineId);
	public Void updateOrderline(OrderlineModel orderlineModel);
	public Void saveOrderline(OrderlineModel orderlineModel);
}
