package com.github.clothesstore.model;

import java.io.Serializable;

public class Address implements Serializable {
	
 

		private static final long serialVersionUID = 1L;
		private Integer id;
		private String street;
		private String district;
		private String number;
		private String note;
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
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
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
			return "Address [id=" + id + ", street=" + street + ", district=" + district + ", number=" + number
					+ ", note=" + note + "]";
		}
		
}
