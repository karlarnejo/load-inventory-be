package com.starter.starter_demo.crud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.starter.starter_demo.common.ApiResult;
import com.starter.starter_demo.exception.UserAccountDisabledException;
import com.starter.starter_demo.exception.UserAccountExpiredException;
import com.starter.starter_demo.exception.UserAccountLockedException;
import com.starter.starter_demo.exception.UserInvalidPasswordException;
import com.starter.starter_demo.exception.UserInvalidUsernameException;
import com.starter.starter_demo.exception.UserPasswordExpiredException;

@RestControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = UserAccountDisabledException.class)
	public ApiResult exception(UserAccountDisabledException exception) {
		return ApiResult.createResponse(null, "CUSTOM_ERROR_STATUS", "User account is disabled.");
	}
	
	@ExceptionHandler(value = UserAccountLockedException.class)
	public ApiResult exception(UserAccountLockedException exception) {
		return ApiResult.createResponse(null, "CUSTOM_ERROR_STATUS", "User account is locked.");
	}
	
	@ExceptionHandler(value = UserAccountExpiredException.class)
	public ApiResult exception(UserAccountExpiredException exception) {
		return ApiResult.createResponse(null, "CUSTOM_ERROR_STATUS", "User account has expired.");
	}
	
	@ExceptionHandler(value = UserPasswordExpiredException.class)
	public ApiResult exception(UserPasswordExpiredException exception) {
		return ApiResult.createResponse(null, "CUSTOM_ERROR_STATUS", "User account's password has expired");
	}
	
	@ExceptionHandler(value = UserInvalidUsernameException.class)
	public ApiResult exception(UserInvalidUsernameException exception) {
		return ApiResult.createResponse(null, "CUSTOM_ERROR_STATUS", "Invalid username");
	}
	
	@ExceptionHandler(value = UserInvalidPasswordException.class)
	public ApiResult exception(UserInvalidPasswordException exception) {
		return ApiResult.createResponse(null, "CUSTOM_ERROR_STATUS", "Invalid password.");
	}
}
