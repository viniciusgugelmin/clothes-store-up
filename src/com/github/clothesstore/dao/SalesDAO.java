package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Sales;

public interface SalesDAO {
	
	void associate(Sales obj);
	void deleteByProductId(Integer product_id);
	void deleteByBuyerId(Integer buyer_id);
	List<Sales> findByProductId(Integer product_id);
	List<Sales> findByBuyerId(Integer buyer_id);
	List<Sales> findAll();
}
