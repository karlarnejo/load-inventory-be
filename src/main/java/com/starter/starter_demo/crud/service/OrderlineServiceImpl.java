package com.starter.starter_demo.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.starter_demo.crud.dao.CrudRepositoryOrderline;
import com.starter.starter_demo.crud.entity.Customer;
import com.starter.starter_demo.crud.entity.Orderline;
import com.starter.starter_demo.crud.models.CustomerModel;
import com.starter.starter_demo.crud.models.DeleteCustomerModel;
import com.starter.starter_demo.crud.models.DeleteOrderModel;
import com.starter.starter_demo.crud.models.OrderlineCustomerModel;
import com.starter.starter_demo.crud.models.OrderlineModel;
import com.starter.starter_demo.crud.models.PaginationModel;
import com.starter.starter_demo.crud.models.SearchParams;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderlineServiceImpl implements OrderlineService {

	@Autowired
	private CrudRepositoryOrderline crudRepositoryOrderline;
	
	@Override
	public PaginationModel searchFindAll(SearchParams searchParams) {
		// TODO Auto-generated method stub
		
		PaginationModel paginationModel = new PaginationModel();
		List<Object> orderlineCustomerModel = new ArrayList<Object>();

		/*
		 * of(page, itemsPerPage) 
		 * page is represented as index (starts with 0) instead of the usual
		 * slice start and slice end in MarkLogic.
		 * */
		int page = (searchParams.getPageInput()-1);
		int itemsPerPage = searchParams.getItemsPerPage();
		
//		if(searchParams.getSortItem().equals("")) {
//			
//		}
		
		//use entity.property to sort from joined tables.
		Sort sort = searchParams.getSortDirection().equals("Ascending") ? Sort.by(searchParams.getSortItem()).ascending() :
			Sort.by(searchParams.getSortItem()).descending();
		
		Pageable paging = PageRequest.of(page, itemsPerPage, sort);
		Page<Orderline> findAllOrderlineCustomers;		
		findAllOrderlineCustomers = crudRepositoryOrderline.searchFindAll(paging, searchParams.getSearchQuery());
		
		findAllOrderlineCustomers.getContent().forEach(data -> {
			OrderlineCustomerModel orderlineCustomerModelTemp = new OrderlineCustomerModel(data);
			orderlineCustomerModel.add(orderlineCustomerModelTemp);
		});
				
		paginationModel.setData(orderlineCustomerModel);
		paginationModel.setItemsPerPage(findAllOrderlineCustomers.getSize());
		paginationModel.setPageInput(findAllOrderlineCustomers.getPageable().getPageNumber());
		paginationModel.setTotalPages(findAllOrderlineCustomers.getTotalPages());
		
		return paginationModel;
	}

//	@Override
//	public OrderlineCustomerModel findAllInnerJoinWhere(Long customerId) {
//		// TODO Auto-generated method stub
//		
//		OrderlineCustomerModel orderlineCustomerModel = new OrderlineCustomerModel(crudRepositoryOrderline.findAllInnerJoinWhere(customerId));
//
//		return orderlineCustomerModel;
//	}

	@Override
	public Void deleteByOrderlineId(DeleteOrderModel orderlineId) {
		crudRepositoryOrderline.deleteByOrderlineId(orderlineId.getOrderlineId());
		
		return null;
	}
	
	@Override
	public Void saveOrderline(OrderlineModel orderlineModel) {
		
		//TODO: generate primary key
		
		orderlineModel.setOrderlineId("sample1");
		crudRepositoryOrderline.saveAndFlush(orderlineModel.toEntity());
		
		return null;
	}

	@Override
	public Void updateOrderline(OrderlineModel orderlineModel) {
		// TODO Auto-generated method stub
		
		crudRepositoryOrderline.saveAndFlush(orderlineModel.toEntity());
		
		return null;
	}
}
