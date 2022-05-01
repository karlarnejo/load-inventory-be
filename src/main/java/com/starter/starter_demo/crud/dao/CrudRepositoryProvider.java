package com.starter.starter_demo.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.starter.starter_demo.crud.entity.Provider;

@Repository
public interface CrudRepositoryProvider extends JpaRepository<Provider, Long> {

	@Query("SELECT p FROM Provider p WHERE "
			+ "LOWER(p.providerName) LIKE lower(concat('%', :searchQuery,'%'))")
	public List<Provider> findByProviderName(@Param("searchQuery") String searchQuery);
}
