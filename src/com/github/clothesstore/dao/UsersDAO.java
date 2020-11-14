package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.model.Users;

public interface UsersDAO {
	
	void associate(Users obj, char gender, Integer document_id);
	void update (Users obj, String oldDocument);
	void deleteByDocument(String document);
	void deleteByGender(char gender);
	void deleteByDocumentId(Integer document_id);
	Users findByDocument(String document);
	List<Users> findByGender(char gender);
	List<Users> findByDocumentId(Integer document_id);
	List<Users> findAll();
}
