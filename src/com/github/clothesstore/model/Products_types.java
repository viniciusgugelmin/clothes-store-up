package com.github.clothesstore.model;

import java.io.Serializable;

public class Products_types implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id = 0;
	private String type = "";
	private char gender = '0';
	private String size = "";
	
	public Products_types() {
		
	}
	
	public Products_types(Integer id, String type, char gender, String size) {
		this.id = id;
		this.type = type;
		this.gender = gender;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "{id:" + id + ", type:'" + type + "', gender:'" + gender + "', size:'" + size + "'}";
	}
}
