package com.starter.starter_demo.crud.service;

import com.starter.starter_demo.crud.models.LoginRequest;

public interface UserServices {
	public LoginRequest findByUsername(String username);
}
