package com.github.clothesstore.model;

import java.io.Serializable;

public class Genders implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private char gender = '0';
	
	public Genders() {
		
	}
	
	public Genders(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "{gender:'" + gender + "'}";
	}
	
	
}

