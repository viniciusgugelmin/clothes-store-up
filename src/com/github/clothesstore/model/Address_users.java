package com.github.clothesstore.model;

import java.io.Serializable;

public class Address_users implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_address = 0;
	private String document_user = "";
	
	public Address_users() {
		
	}
	
	public Address_users(Integer id_address, String document_user) {
		this.id_address = id_address;
		this.document_user = document_user;
	}
	
	public Integer getId_address() {
		return id_address;
	}
	
	public void setId_address(Integer id_address) {
		this.id_address = id_address;
	}
	
	public String getDocument_user() {
		return document_user;
	}
	
	public void setDocument_user(String document_user) {
		this.document_user = document_user;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "{id_address:" + id_address + ", document_user:'" + document_user + "'}";
	}
}
