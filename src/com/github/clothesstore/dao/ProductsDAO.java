package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Products;

public interface ProductsDAO {
	
	void associate(Products obj);
	void deleteById(Integer id);
	void deleteByType_id(Integer type_id);
	Products findById(Integer id);
	List<Products> findType_id(Integer type_id);
	List<Products> findAll();
}
