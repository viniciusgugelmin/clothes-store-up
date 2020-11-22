package com.github.clothesstore.requests;

import java.util.List;

import com.github.clothesstore.dao.DAOFactory;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.ProductsDAO;
import com.github.clothesstore.dao.Products_typesDAO;
import com.github.clothesstore.dao.Users_payment_methods_dataDAO;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Products;
import com.github.clothesstore.model.Products_types;
import com.github.clothesstore.model.Sales;
import com.github.clothesstore.model.Users_payment_methods_data;
import com.github.clothesstore.model.ValidationReturn;

public class SalesRequest {

	public ValidationReturn associate(Sales obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		ProductsDAO productDAO = DAOFactory.createProductsDAO();
		Products product = productDAO.findById(obj.getProduct_id());
		
		System.out.println(product);
		
		if (product == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("product not found");
			
			return validationReturn;
		}
		
		Users_payment_methods_dataDAO userDAO = DAOFactory.createUsers_payment_methods_dataDAO();
		List<Users_payment_methods_data> user = userDAO.findById(obj.getBuyer_id());
		
		System.out.println(user);
		
		if (user == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("user_payment_method_data not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
}
