package com.github.clothesstore.requests;

public class ValidationReturn {
	
	private Integer status;
	private String response;
	
	public ValidationReturn() {
		this.status = 200;
		this.response = "OK";
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		return "{STATUS: " + status + ", RESPONSE: " + response + "}";
	}
}
