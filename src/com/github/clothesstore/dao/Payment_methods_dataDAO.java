package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;

public interface Payment_methods_dataDAO {
	
	void associate(Payment_methods_data obj, Integer payment_method_type);
	void deleteById(Integer id);
	void deleteByType(Integer payment_method_type);
	Payment_methods_data findById(Integer id);
	List<Payment_methods_data> findByType(Integer payment_method_type);
	List<Payment_methods_data> findAll();
}
