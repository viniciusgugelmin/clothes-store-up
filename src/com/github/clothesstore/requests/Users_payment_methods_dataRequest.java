package com.github.clothesstore.requests;

import com.github.clothesstore.dao.DAOFactory;
import com.github.clothesstore.dao.Payment_methods_dataDAO;
import com.github.clothesstore.dao.UsersDAO;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.model.Users;
import com.github.clothesstore.model.ValidationReturn;

public class Users_payment_methods_dataRequest {
	
	public ValidationReturn associate(Integer payment_method_data_id, String document_user) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		Payment_methods_dataDAO paymentMethodDataDAO = DAOFactory.createPayment_methods_dataDAO();
		Payment_methods_data paymentMethodData = paymentMethodDataDAO.findById(payment_method_data_id);
		
		System.out.println(paymentMethodData);
		
		if (paymentMethodData == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("payment_method_data not found");
			
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
	
	public ValidationReturn deleteById(Integer id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (id == 0 || id < 0) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("'id' invalid");
			
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
	
	public ValidationReturn deleteByPaymentMethodDataId(Integer payment_method_data_id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		Payment_methods_dataDAO paymentMethodDataDAO = DAOFactory.createPayment_methods_dataDAO();
		Payment_methods_data paymentMethodData = paymentMethodDataDAO.findById(payment_method_data_id);
		
		System.out.println(paymentMethodData);
		
		if (paymentMethodData == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("payment_method_data not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
}
