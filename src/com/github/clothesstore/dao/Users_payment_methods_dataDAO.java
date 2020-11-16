package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Address_users;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.model.Users;

public interface Users_payment_methods_dataDAO {
	
	void associate(Integer id_address, String document_user);
	void deleteByDocument(String document);
	void deleteById(Integer id_address);
	List<Address_users> findByDocument(String document);
	List<Address_users> findById(Integer id_address);
	List<Address_users> findAll();
}
