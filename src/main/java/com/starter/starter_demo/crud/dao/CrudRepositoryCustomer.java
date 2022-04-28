package com.starter.starter_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;

import com.starter.starter_demo.common.projections.ProjectionOne;
import com.starter.starter_demo.crud.entity.Customer;

@Repository
public interface CrudRepositoryCustomer extends JpaRepository<Customer, Long> {
	public Customer findByCustomerId(Long customerId);
	
	//Used LOWER for case insensitive search since ILIKE from Postgresql is not supported in JPA.
	@Query("SELECT c FROM Customer c WHERE "
			+ "LOWER(c.firstName) LIKE %:searchQuery% or "
			+ "LOWER(c.lastName) LIKE %:searchQuery% or "
			+ "LOWER(c.address) LIKE %:searchQuery% or "
			+ "LOWER(c.gender) LIKE %:searchQuery% or "
			+ "LOWER(c.contactNo) LIKE %:searchQuery% or "
			+ "LOWER(c.middleName) LIKE %:searchQuery%")
	public Page<Customer> searchFindAll(Pageable pageable, @Param("searchQuery") String searchQuery);
	
	@Query("SELECT c FROM Customer c WHERE "
			+ "LOWER(c.firstName) LIKE %:searchQuery% or "
			+ "LOWER(c.lastName) LIKE %:searchQuery% or "
			+ "LOWER(c.middleName) LIKE %:searchQuery%")
	public List<Customer> findByCustomerName(@Param("searchQuery") String searchQuery);
	
	@Modifying
	@Query("DELETE FROM Customer c WHERE c.customerId=:customerId")
	public void deleteByCustomerId(@Param("customerId") String customerId);
		
	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
	public ProjectionOne findProjectionOne(Long customerId);
	
	@Query("SELECT c.firstName FROM Customer c WHERE c.customerId = ?1")
	public Customer findSpecific(Long customerId);
	
	@Query("SELECT o from Customer o "
			+ "WHERE o.customerId=:customerId")
	public Customer findByCustomerId(@Param("customerId") String customerId);
}
