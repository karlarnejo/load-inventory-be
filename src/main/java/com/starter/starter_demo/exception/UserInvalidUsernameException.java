package com.starter.starter_demo.exception;

import java.util.UUID;

public class UserInvalidUsernameException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private Object optionalData;
	private Throwable errorData;
	final private UUID transactionId = UUID.randomUUID();
	
	public UserInvalidUsernameException() {
		
	}
	
	public UserInvalidUsernameException(Throwable errorData) {
		this.errorData = errorData;
	}
	
	public UserInvalidUsernameException(Throwable errorData, Object optionalData) {
		this.errorData = errorData;
		this.optionalData = optionalData;
	}

	public Object getOptionalData() {
		return optionalData;
	}

	public void setOptionalData(Object optionalData) {
		this.optionalData = optionalData;
	}

	public Throwable getErrorData() {
		return errorData;
	}

	public void setErrorData(Throwable errorData) {
		this.errorData = errorData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getTransactionId() {
		return transactionId;
	}
}
