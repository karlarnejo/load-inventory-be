package com.starter.starter_demo.common;

import java.util.UUID;

public class ApiResultError {
	
	private String message;
	private String status;
	private UUID transactionId;
	
	public ApiResultError() {
		
	}
	
	public ApiResultError(String message, String status, UUID transactionId) {
		this.message = message;
		this.status = status;
		this.transactionId = transactionId;
	}
	
	public static ApiResultError createResponse(String message, String status, UUID transactionId) {
		return new ApiResultError(message, status, transactionId);
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

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}
}
