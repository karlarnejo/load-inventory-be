package com.starter.starter_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.starter_demo.crud.entity.Provider;

public interface CrudRepositoryProvider extends JpaRepository<Provider, Long> {

}
