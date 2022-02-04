package com.starter.starter_demo.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.starter.starter_demo.crud.entity.Orderline;

@Repository
public interface CrudRepositoryOrderline extends JpaRepository<Orderline, Long> {
	
//	@Query(
//	  value = "SELECT * FROM orderline o INNER JOIN customer c ON c.customerid = o.customerid", 
//	  nativeQuery = true)
	@Query("SELECT o FROM Orderline o JOIN o.customer c")
	public List<Orderline> findAllInnerJoin();
	
//	@Query("SELECT o FROM Orderline o JOIN o.customer c WHERE c.customerId = ?1")
	@Query("SELECT new com.starter.starter_demo.crud.models.OrderlineCustomerModel(c.firstName, c.lastName, c.middleName, o.orderCode, o.status, o.orderDate) FROM Orderline o JOIN o.customer c WHERE c.customerId = ?1")
	public Orderline findAllInnerJoinWhere(Long customerId);	
}
