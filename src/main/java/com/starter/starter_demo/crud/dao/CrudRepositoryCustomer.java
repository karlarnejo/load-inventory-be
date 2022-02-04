package com.starter.starter_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.starter.starter_demo.common.projections.ProjectionOne;
import com.starter.starter_demo.crud.entity.Customer;

@Repository
public interface CrudRepositoryCustomer extends JpaRepository<Customer, Long> {
	public Customer findByCustomerId(Long customerId);
	
	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	public ProjectionOne findProjectionOne(Long customerId);
	
	@Query("SELECT c.firstName FROM Customer c WHERE c.customerId = ?1")
	public Customer findSpecific(Long customerId);
}
