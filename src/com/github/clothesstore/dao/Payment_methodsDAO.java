package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Payment_methods;

public interface Payment_methodsDAO extends DAO<Payment_methods> {
	
	void deleteById(Integer id);
	Payment_methods findById(Integer id);
	List<Payment_methods> findAll();
}
