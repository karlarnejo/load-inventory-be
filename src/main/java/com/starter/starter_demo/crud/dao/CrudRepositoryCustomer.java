package com.starter.starter_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.starter.starter_demo.common.projections.ProjectionOne;
import com.starter.starter_demo.crud.entity.Customer;

@Repository
public interface CrudRepositoryCustomer extends JpaRepository<Customer, Long> {
	public Customer findByCustomerId(Long customerId);
	
	@Query("SELECT c from Customer c WHERE "
			+ "c.firstName like %:searchQuery% or "
			+ "c.lastName like %:searchQuery% or "
			+ "c.address like %:searchQuery% or "
			+ "c.gender like %:searchQuery% or "
			+ "c.contactNo like %:searchQuery% or "
			+ "c.middleName like %:searchQuery%")
	public Page<Customer> searchFindAll(Pageable pageable, @Param("searchQuery") String searchQuery);
		
	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	public ProjectionOne findProjectionOne(Long customerId);
	
	@Query("SELECT c.firstName FROM Customer c WHERE c.customerId = ?1")
	public Customer findSpecific(Long customerId);
}
