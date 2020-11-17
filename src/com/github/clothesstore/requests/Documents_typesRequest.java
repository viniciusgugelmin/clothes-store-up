package com.github.clothesstore.requests;

import com.github.clothesstore.model.Documents_types;
import com.github.clothesstore.model.ValidationReturn;

public class Documents_typesRequest {
	
	public ValidationReturn insert(Documents_types obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getType().equals("") || obj.getType().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'type' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn update(Documents_types obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getId().equals(0) || obj.getId() < 0) {
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
		
		if (id.equals(0) || id < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
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
}
