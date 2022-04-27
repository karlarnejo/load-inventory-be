package com.starter.starter_demo.crud.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.starter.starter_demo.crud.entity.Orderline;

@Repository
public interface CrudRepositoryOrderline extends JpaRepository<Orderline, Long> {
	
	@Query("SELECT o FROM Orderline o "
			+ "INNER JOIN o.customer c "
			+ "INNER JOIN o.promo p "
			+ "INNER JOIN p.provider pp "
			+ "WHERE "
			+ "LOWER(c.firstName) LIKE %:searchQuery% or "
			+ "LOWER(c.lastName) LIKE %:searchQuery% or "
			+ "LOWER(c.middleName) LIKE %:searchQuery% or "
			+ "LOWER(o.orderCode) LIKE %:searchQuery% or "
			+ "LOWER(p.promoName) LIKE %:searchQuery% or "
			+ "LOWER(pp.providerName) LIKE %:searchQuery%")
	public Page<Orderline> searchFindAll(Pageable pageable, @Param("searchQuery") String searchQuery);
	
	@Modifying
	@Query("DELETE FROM Orderline c WHERE c.orderlineId=:orderlineId")
	public void deleteByOrderlineId(@Param("orderlineId") String orderlineId);

//	@Query("SELECT o FROM Orderline o JOIN o.customer c WHERE c.customerId = ?1")
//	@Query("SELECT new com.starter.starter_demo.crud.models.OrderlineCustomerModel(c.firstName, c.lastName, c.middleName, o.orderCode, o.status, o.createdAt) FROM Orderline o JOIN o.customer c WHERE c.customerId = ?1")
//	public Orderline findAllInnerJoinWhere(Long customerId);	
}
