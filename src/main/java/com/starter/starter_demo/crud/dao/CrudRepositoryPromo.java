package com.starter.starter_demo.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.starter.starter_demo.crud.entity.Promo;

@Repository
public interface CrudRepositoryPromo extends JpaRepository<Promo, Long> {

	@Query("SELECT p FROM Promo p "
			+ "WHERE "
			+ "LOWER(p.promoName) LIKE lower(concat('%', :searchQuery,'%')) AND "
			+ "providerId=:providerId")
	public List<Promo> findByPromoName(@Param("searchQuery") String searchQuery,
			@Param("providerId") String providerId);
}
