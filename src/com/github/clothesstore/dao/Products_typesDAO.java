package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Products_types;

public interface Products_typesDAO {
	
	void associate(Products_types obj);
	void deleteById(Integer id);
	void deleteByGender(char gender);
	Products_types findById(Integer id);
	List<Products_types> findByType(String type);
	List<Products_types> findByGender(char gender);
	List<Products_types> findBySize(String size);
	List<Products_types> findAll();
}
