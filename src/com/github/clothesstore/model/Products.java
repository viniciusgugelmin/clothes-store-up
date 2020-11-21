package com.github.clothesstore.model;

import java.io.Serializable;

public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id = 0;
	private Integer type_id = 0;
	private String name = "";
	private String brand = "";
	private double price = 0;
	private double discount = 0;
	private Integer quantity_stock = 0;
	
	public Products() {
		
	}
	
	public Products(Integer id, Integer type_id, String name, String brand, float price, float discount, Integer quantity_stock) {
		this.id = id;
		this.type_id = type_id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.discount = discount;
		this.quantity_stock = quantity_stock;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Integer getQuantity_stock() {
		return quantity_stock;
	}

	public void setQuantity_stock(Integer quantity_stock) {
		this.quantity_stock = quantity_stock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", type_id:" + type_id + ", name:'" + name + "', brand:'" + brand + "', price:" +  price + ", discount:" + discount + ", quantity_stock:" + quantity_stock + "}";
	}
}
