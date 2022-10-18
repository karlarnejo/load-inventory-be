package com.starter.starter_demo.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.starter.starter_demo.common.ApiResultError;
import com.starter.starter_demo.constants.ERR_CONSTANTS;
import com.starter.starter_demo.exception.UserAccountDisabledException;
import com.starter.starter_demo.exception.UserAccountExpiredException;
import com.starter.starter_demo.exception.UserAccountLockedException;
import com.starter.starter_demo.exception.UserInvalidPasswordException;
import com.starter.starter_demo.exception.UserInvalidUsernameException;
import com.starter.starter_demo.exception.UserPasswordExpiredException;

@RestControllerAdvice
public class UserExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(UserExceptionController.class);

	@ExceptionHandler(value = UserAccountDisabledException.class)
	public ApiResultError exception(UserAccountDisabledException exception) {
		logger.error(ERR_CONSTANTS.ACCOUNT_DISABLED + ": {}. Stacktrace cause: {}. Transaction ID: {}.", exception.getOptionalData(), exception.getErrorData().getMessage(), exception.getTransactionId());
		return ApiResultError.createResponse(ERR_CONSTANTS.ACCOUNT_DISABLED, "CUSTOM_ERROR_STATUS", exception.getTransactionId().toString());
	}
	
	@ExceptionHandler(value = UserAccountLockedException.class)
	public ApiResultError exception(UserAccountLockedException exception) {
		logger.error(ERR_CONSTANTS.ACCOUNT_LOCKED + ": {}. Stacktrace cause: {}. Transaction ID: {}.", exception.getOptionalData(), exception.getErrorData().getMessage(), exception.getTransactionId());
		return ApiResultError.createResponse(ERR_CONSTANTS.ACCOUNT_LOCKED, "CUSTOM_ERROR_STATUS", exception.getTransactionId().toString());
	}
	
	@ExceptionHandler(value = UserAccountExpiredException.class)
	public ApiResultError exception(UserAccountExpiredException exception) {
		logger.error(ERR_CONSTANTS.ACCOUNT_EXPIRED + ": {}. Stacktrace cause: {}. Transaction ID: {}.", exception.getOptionalData(), exception.getErrorData().getMessage(), exception.getTransactionId());
		return ApiResultError.createResponse(ERR_CONSTANTS.ACCOUNT_EXPIRED, "CUSTOM_ERROR_STATUS", exception.getTransactionId().toString());
	}
	
	@ExceptionHandler(value = UserPasswordExpiredException.class)
	public ApiResultError exception(UserPasswordExpiredException exception) {
		logger.error(ERR_CONSTANTS.ACCOUNT_PASSWORD_EXPIRED + ": {}. Stacktrace cause: {}. Transaction ID: {}.", exception.getOptionalData(), exception.getErrorData().getMessage(), exception.getTransactionId());
		return ApiResultError.createResponse(ERR_CONSTANTS.ACCOUNT_PASSWORD_EXPIRED, "CUSTOM_ERROR_STATUS", exception.getTransactionId().toString());
	}
	
	@ExceptionHandler(value = UserInvalidUsernameException.class)
	public ApiResultError exception(UserInvalidUsernameException exception) {
		logger.error(ERR_CONSTANTS.USERNAME_INVALID + ": {}. Stacktrace cause: {}. Transaction ID: {}.", exception.getOptionalData(), exception.getErrorData().getMessage(), exception.getTransactionId());
		return ApiResultError.createResponse(ERR_CONSTANTS.USERNAME_INVALID, "CUSTOM_ERROR_STATUS", exception.getTransactionId().toString());
	}
	
	@ExceptionHandler(value = UserInvalidPasswordException.class)
	public ApiResultError exception(UserInvalidPasswordException exception) {
		logger.error(ERR_CONSTANTS.PASSWORD_INVALID + ": {}. Stacktrace cause: {}. Transaction ID: {}.", exception.getOptionalData(), exception.getErrorData().getMessage(), exception.getTransactionId());
		return ApiResultError.createResponse(ERR_CONSTANTS.PASSWORD_INVALID, "CUSTOM_ERROR_STATUS", exception.getTransactionId().toString());
	}
}
