package com.starter.starter_demo.crud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.starter.starter_demo.common.ApiResultRest;
import com.starter.starter_demo.exception.UserAccountDisabledException;
import com.starter.starter_demo.exception.UserAccountExpiredException;
import com.starter.starter_demo.exception.UserAccountLockedException;
import com.starter.starter_demo.exception.UserInvalidPasswordException;
import com.starter.starter_demo.exception.UserInvalidUsernameException;
import com.starter.starter_demo.exception.UserPasswordExpiredException;

@RestControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = UserAccountDisabledException.class)
	public ApiResultRest exception(UserAccountDisabledException exception) {
		return ApiResultRest.createResponse(null, "CUSTOM_ERROR_STATUS", "User account is disabled.");
	}
	
	@ExceptionHandler(value = UserAccountLockedException.class)
	public ApiResultRest exception(UserAccountLockedException exception) {
		return ApiResultRest.createResponse(null, "CUSTOM_ERROR_STATUS", "User account is locked.");
	}
	
	@ExceptionHandler(value = UserAccountExpiredException.class)
	public ApiResultRest exception(UserAccountExpiredException exception) {
		return ApiResultRest.createResponse(null, "CUSTOM_ERROR_STATUS", "User account has expired.");
	}
	
	@ExceptionHandler(value = UserPasswordExpiredException.class)
	public ApiResultRest exception(UserPasswordExpiredException exception) {
		return ApiResultRest.createResponse(null, "CUSTOM_ERROR_STATUS", "User account's password has expired");
	}
	
	@ExceptionHandler(value = UserInvalidUsernameException.class)
	public ApiResultRest exception(UserInvalidUsernameException exception) {
		return ApiResultRest.createResponse(null, "CUSTOM_ERROR_STATUS", "Invalid username");
	}
	
	@ExceptionHandler(value = UserInvalidPasswordException.class)
	public ApiResultRest exception(UserInvalidPasswordException exception) {
		return ApiResultRest.createResponse(null, "CUSTOM_ERROR_STATUS", "Invalid password.");
	}
}
