package com.github.clothesstore.model;

import java.io.Serializable;

public class Payment_methods_data implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private Integer payment_method_type = 0;
	private String card_number = "";
	private String expiry_date = "";
	private String cvc = "";


	public Payment_methods_data() {
	}
	
	public Payment_methods_data(Integer id) {
		this.id = id;
	}
	
	public Payment_methods_data(String card_number, String expiry_date, String cvc) {
		this.card_number = card_number;
		this.expiry_date = expiry_date;
		this.cvc = cvc;
	}
	
	public Payment_methods_data(Integer id, String card_number, String expiry_date, String cvc) {
		this.id = id;
		this.card_number = card_number;
		this.expiry_date = expiry_date;
		this.cvc = cvc;
	}
	
	public Payment_methods_data(Integer id, Integer payment_method_type, String card_number, String expiry_date, String cvc) {
		this.id = id;
		this.payment_method_type = payment_method_type;
		this.card_number = card_number;
		this.expiry_date = expiry_date;
		this.cvc = cvc;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPayment_method_type() {
		return payment_method_type;
	}

	public void setPayment_method_type(Integer payment_method_type) {
		this.payment_method_type = payment_method_type;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getCvc() {
		return cvc;
	}
	
	public void setCvc(String cvc) {
		this.cvc = cvc;
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
		Payment_methods_data other = (Payment_methods_data) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", payment_method_type:'" + payment_method_type + "', card_number:'" + card_number + "', expiry_date:'" + expiry_date + "', cvc:'" + cvc + "'}";
	}
}