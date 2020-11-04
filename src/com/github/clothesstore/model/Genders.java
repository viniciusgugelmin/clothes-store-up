package com.github.clothesstore.model;

import java.io.Serializable;

public class Genders implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String genders;

	public String getGender() {
		return genders;
	}

	public void setGender(String gender) {
		this.genders = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genders == null) ? 0 : genders.hashCode());
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
		Genders other = (Genders) obj;
		if (genders == null) {
			if (other.genders != null)
				return false;
		} else if (!genders.equals(other.genders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genders [gender=" + genders + "]";
	}
	
	
}

