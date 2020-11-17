package com.github.clothesstore.requests;

import com.github.clothesstore.dao.AddressDAO;
import com.github.clothesstore.dao.DAOFactory;
import com.github.clothesstore.dao.Documents_typesDAO;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.UsersDAO;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Documents_types;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.model.Users;
import com.github.clothesstore.model.ValidationReturn;

public class Address_usersRequest {
	
	public ValidationReturn associate(Integer id_address, String document_user) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		AddressDAO addressDAO = DAOFactory.createAddressDAO();
		Address addressItem = addressDAO.findById(id_address);
		
		System.out.println(addressItem);
		
		if (addressItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("address not found");
			
			return validationReturn;
		}
		
		UsersDAO userDAO = DAOFactory.createUsersDAO();
		Users userItem = userDAO.findByDocument(document_user);
		
		System.out.println(userItem);
		
		if (userItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("user not found");
			
			return validationReturn;
		}
		

		return validationReturn;
	}
	
	public ValidationReturn deleteByDocument(String document) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		UsersDAO userDAO = DAOFactory.createUsersDAO();
		Users userItem = userDAO.findByDocument(document);
		
		System.out.println(userItem);
		
		if (userItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("user not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteById(Integer id_address) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		AddressDAO addressDAO = DAOFactory.createAddressDAO();
		Address addressItem = addressDAO.findById(id_address);
		
		System.out.println(addressItem);
		
		if (addressItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("address not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
}
