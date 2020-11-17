package com.github.clothesstore.requests;

import com.github.clothesstore.dao.DAOFactory;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Products_types;
import com.github.clothesstore.model.ValidationReturn;

public class Products_typesRequest {

	public ValidationReturn associate(Products_types obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getType().equals("") || obj.getType().equals("null") || obj.getType().isEmpty()) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'type' is missing");
		}
		
		if (obj.getSize().equals("") || obj.getSize().equals("null") || obj.getSize().isEmpty()) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'type' is missing");
		}
		
		GendersDAO genderDAO = DAOFactory.createGendersDAO();
		Genders genderItem = genderDAO.findByGender(obj.getGender());
		
		System.out.println(genderItem);
		
		if (genderItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("gender not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
}
