package com.github.clothesstore.model;

import java.io.Serializable;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String street = "";
	private String district = "";
	private Integer number = 0;
	private String note = "";
	
	public Address() {
	}

	public Address(String street, String district, Integer number) {
		this.street = street;
		this.district = district;
		this.number = number;
	}
	
	public Address(Integer id, String street, String district, Integer number) {
		this.id = id;
		this.street = street;
		this.district = district;
		this.number = number;
	}
	
	public Address(String street, String district, Integer number, String note) {
		this.street = street;
		this.district = district;
		this.number = number;
		this.note = note;
	}
	
	public Address(Integer id, String street, String district, Integer number, String note) {
		this.id = id;
		this.street = street;
		this.district = district;
		this.number = number;
		this.note = note;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getByString(String property) {
		
		switch (property) {
		case "id":
			return id.toString();
		case "street":
			return street;
		case "destrict":
			return district;
		case "number":
			return number.toString();
		case "note":
			return note;
		default:
			return id.toString();
		}
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((district == null) ? 0 : district.hashCode());
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
		Address other = (Address) obj;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "{id=" + id + ", street='" + street + "', district='" + district + "', number=" + number
				+ ", note='" + note + "'}";
	}	
}
