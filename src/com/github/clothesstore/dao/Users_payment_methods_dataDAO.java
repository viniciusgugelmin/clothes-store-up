package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Address_users;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.model.Users;
import com.github.clothesstore.model.Users_payment_methods_data;

public interface Users_payment_methods_dataDAO {
	
	void associate(Integer payment_method_data_id, String document_user);
	void deleteById(Integer id);
	void deleteByDocument(String document);
	void deleteByPaymentMethodDataId(Integer payment_method_data_id);
	List<Users_payment_methods_data> findById(Integer id);
	List<Users_payment_methods_data> findByDocument(String document);
	List<Users_payment_methods_data> findByPaymentMethodDataId(Integer payment_method_data_id);
	List<Users_payment_methods_data> findAll();
}
