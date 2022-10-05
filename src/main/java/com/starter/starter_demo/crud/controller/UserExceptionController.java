package com.starter.starter_demo.crud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.starter.starter_demo.common.ApiResultError;
import com.starter.starter_demo.exception.UserAccountDisabledException;
import com.starter.starter_demo.exception.UserAccountExpiredException;
import com.starter.starter_demo.exception.UserAccountLockedException;
import com.starter.starter_demo.exception.UserInvalidPasswordException;
import com.starter.starter_demo.exception.UserInvalidUsernameException;
import com.starter.starter_demo.exception.UserPasswordExpiredException;

@RestControllerAdvice
public class UserExceptionController {

	@ExceptionHandler(value = UserAccountDisabledException.class)
	public ApiResultError exception(UserAccountDisabledException exception) {
		return ApiResultError.createResponse("User account is disabled.", "CUSTOM_ERROR_STATUS");
	}
	
	@ExceptionHandler(value = UserAccountLockedException.class)
	public ApiResultError exception(UserAccountLockedException exception) {
		return ApiResultError.createResponse("User account is locked.", "CUSTOM_ERROR_STATUS");
	}
	
	@ExceptionHandler(value = UserAccountExpiredException.class)
	public ApiResultError exception(UserAccountExpiredException exception) {
		return ApiResultError.createResponse("User account has expired.", "CUSTOM_ERROR_STATUS");
	}
	
	@ExceptionHandler(value = UserPasswordExpiredException.class)
	public ApiResultError exception(UserPasswordExpiredException exception) {
		return ApiResultError.createResponse("User account's password has expired", "CUSTOM_ERROR_STATUS");
	}
	
	@ExceptionHandler(value = UserInvalidUsernameException.class)
	public ApiResultError exception(UserInvalidUsernameException exception) {
		return ApiResultError.createResponse("Invalid username", "CUSTOM_ERROR_STATUS");
	}
	
	@ExceptionHandler(value = UserInvalidPasswordException.class)
	public ApiResultError exception(UserInvalidPasswordException exception) {
		return ApiResultError.createResponse("Invalid password.", "CUSTOM_ERROR_STATUS");
	}
}
