package com.starter.starter_demo.common;

import java.util.UUID;

public class ApiResultError {
	
	private String message;
	private String status;
	final private UUID transactionId = UUID.randomUUID();
	
	public ApiResultError() {
		
	}
	
	public ApiResultError(String message, String status) {
		this.message = message;
		this.status = status;
	}
	
	public static ApiResultError createResponse(String message, String status) {
		return new ApiResultError(message, status);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getTransactionId() {
		return transactionId;
	}
}
