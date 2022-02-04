package com.starter.starter_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.starter.starter_demo.crud.entity.Userr;

@Repository
public interface CrudRepositoryUser extends JpaRepository<Userr, Long> {
	public Userr findByUsername(String username);
}
