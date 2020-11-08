package com.github.clothesstore.requests;

import com.github.clothesstore.model.Payment_methods;

public class Payment_methodsRequest {
	
	public ValidationReturn insert(Payment_methods obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getType().equals("") || obj.getType().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'type' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn update(Payment_methods obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getId().equals(0)) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		if (obj.getType().equals("") || obj.getType().equals("null") || obj.getType().isEmpty()) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'type' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteById(Integer id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (id.equals(0)) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn findById(Integer id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (id.equals(0)) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		return validationReturn;
	}
}
