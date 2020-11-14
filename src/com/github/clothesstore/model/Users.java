package com.github.clothesstore.model;

import java.io.Serializable;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	private String document = "";
	private Integer document_id = 0;
	private String name = "";
	private String email = "";
	private String ddi = "";
	private String ddd = "";
	private String phone = "";
	private String password = "";
	private char gender = '0';
	
	public Users() {
	}

	public Users(String document, Integer document_id, String name, String email, String ddi, String ddd, String phone,
			String password, char gender) {
		this.document = document;
		this.document_id = document_id;
		this.name = name;
		this.email = email;
		this.ddi = ddi;
		this.ddd = ddd;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
	}

	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public Integer getDocument_id() {
		return document_id;
	}


	public void setDocument_id(Integer document_id) {
		this.document_id = document_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDdi() {
		return ddi;
	}


	public void setDdi(String ddi) {
		this.ddi = ddi;
	}


	public String getDdd() {
		return ddd;
	}


	public void setDdd(String ddd) {
		this.ddd = ddd;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "{document':" + document + "', document_id:" + document_id + ", name:'" 
	+ name + "', email:'" + email + "', ddi:" + ddi + ", ddd:" + ddd + ", phone:" + phone 
	+ ", password:'" + password  + "', gender':" + gender + "'}";
	}
}
