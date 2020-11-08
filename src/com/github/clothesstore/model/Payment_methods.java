package com.github.clothesstore.model;

import java.io.Serializable;

public class Payment_methods implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private String type = "";

	public Payment_methods() {
	}
	
	public Payment_methods(Integer id) {
		this.id = id;
	}

	public Payment_methods(String type) {
		this.type = type;
	}
	
	public Payment_methods(Integer id, String type) {
		this.id = id;
		this.type = type;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment_methods other = (Payment_methods) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", type='" + type + "'}";
	}
}