package com.github.clothesstore.model;

import java.io.Serializable;

public class Users_payment_methods_data implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private Integer payment_method_data_id = 0;
	private String user_document = "";
	
	public Users_payment_methods_data() {
		
	}
	
	public Users_payment_methods_data(Integer id, Integer payment_method_data_id, String user_document) {
		this.id = id;
		this.payment_method_data_id = payment_method_data_id;
		this.user_document = user_document;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPayment_method_data_id() {
		return payment_method_data_id;
	}
	
	public void setPayment_method_data_id(Integer payment_method_data_id) {
		this.payment_method_data_id = payment_method_data_id;
	}
	
	public String getUser_document() {
		return user_document;
	}
	
	public void setUser_document(String user_document) {
		this.user_document = user_document;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "{id:" + id + ", payment_method_data_id:" + payment_method_data_id + ", user_document:'" + user_document + "'}";
	}
}
