package com.github.clothesstore.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sales implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer product_id = 0;
	private Integer buyer_id = 0;
	private String created_at = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(Calendar.getInstance().getTime());
	
	public Sales() {
		
	}
	
	public Sales(Integer product_id, Integer buyer_id, String created_at) {
		this.product_id = product_id;
		this.buyer_id = buyer_id;
		this.created_at = created_at;
	}
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(Integer buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "{product_id:" + product_id + ", buyer_id:" + buyer_id + ", created_at:'" + created_at + "'}";
	}
}
