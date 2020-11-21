package com.github.clothesstore.requests;

import com.github.clothesstore.dao.DAOFactory;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.Products_typesDAO;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Products;
import com.github.clothesstore.model.Products_types;
import com.github.clothesstore.model.ValidationReturn;

public class ProductsRequest {

	public ValidationReturn associate(Products obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		Products_typesDAO productTypeDAO = DAOFactory.createProducts_typesDAO();
		Products_types productType = productTypeDAO.findById(obj.getType_id());
		
		System.out.println(productType);
		
		if (productType == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("product_type not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
}
