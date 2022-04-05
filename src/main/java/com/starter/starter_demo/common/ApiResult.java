package com.starter.starter_demo.common;

public class ApiResult {
	
	private Object data;
	private String token;
	private String message;
	//private Status status;
	
	public ApiResult() {
		
	}
	
	public ApiResult(Object data, String token, String message) {
		this.data = data;
		this.token = token;
		this.message = message;
	}
	
	public static ApiResult createResponse(Object data, String token, String message) {
		return new ApiResult(data, token, message);
	}
	
	public static ApiResult createResponse(Void data, String token, String message) {
		return new ApiResult(data, token, message);
	}
	
	public Object getdata() {
		return data;
	}
	public void setdata(Object data) {
		this.data = data;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
