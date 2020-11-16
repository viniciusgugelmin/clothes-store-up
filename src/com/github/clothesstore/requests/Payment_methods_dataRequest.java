package com.github.clothesstore.requests;

import java.util.List;

import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.Payment_methods_dataDAO;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;

public class Payment_methods_dataRequest {
	
	public ValidationReturn associate(Payment_methods_data obj, Integer payment_method_type) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		Payment_methodsDAO paymentMethodDAO = DAOFactory.createPayment_methodsDAO();
		Payment_methods paymentMethod = paymentMethodDAO.findById(payment_method_type);
		
		System.out.println(paymentMethod);
		
		if (paymentMethod == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("payment_method not found");
			
			return validationReturn;
		}
		
		if (paymentMethod.getType().equals("BANK_SLIP")) {
			
			Payment_methods_dataDAO paymentMethodDataDAO = DAOFactory.createPayment_methods_dataDAO();
			List<Payment_methods_data> paymentMethodData = paymentMethodDataDAO.findByType(payment_method_type);
			
			if (!paymentMethodData.isEmpty()) {
				validationReturn.setStatus(422);
				validationReturn.setResponse("payment_method already in use");
				
				return validationReturn;
			}
			
			validationReturn.setResponse("BANK_SLIP");
			
			return validationReturn;
		}
		
		if (paymentMethod.getType().equals("CREDIT_CARD")) {
			
			if (obj.getCard_number().equals("") || obj.getExpiry_date().equals("") || obj.getCvc().equals("")) {
				validationReturn.setStatus(422);
				validationReturn.setResponse("data card is missing");
				
				return validationReturn;
			}
			
			if (obj.getCard_number().length() > 19) {
				validationReturn.setStatus(417);
				validationReturn.setResponse("'card_number' needs to be shorter than 19 char");
				
				return validationReturn;
			}
			
			if (obj.getExpiry_date().length() > 7) {
				validationReturn.setStatus(417);
				validationReturn.setResponse("'expiry_date' needs to be shorter than 7 char");
				
				return validationReturn;
			}
			
			if (obj.getCvc().length() > 3) {
				validationReturn.setStatus(417);
				validationReturn.setResponse("'cvc' needs to be shorter than 3 char");
				
				return validationReturn;
			}
			
			validationReturn.setResponse("CREDIT_CARD");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteById(Integer id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (id.equals(0) || id < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteByType(Integer payment_method_type) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (payment_method_type.equals(0) || payment_method_type < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'payment_method_type' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn findById(Integer id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (id.equals(0) || id < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn findByType(Integer payment_method_type) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (payment_method_type.equals(0) || payment_method_type < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'payment_method_type' is missing");
		}
		
		return validationReturn;
	}
}
