package com.starter.starter_demo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.starter_demo.crud.dao.CrudRepositoryUser;
import com.starter.starter_demo.crud.models.LoginRequest;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServicesImpl implements UserServices {

	@Autowired
	CrudRepositoryUser crudRepositoryUser;
	
	@Override
	public LoginRequest findByUsername(String username) {
		// TODO Auto-generated method stub
		LoginRequest userModel = new LoginRequest(crudRepositoryUser.findByUsername(username));
				
		return userModel;
	}

}
