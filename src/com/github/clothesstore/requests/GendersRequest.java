package com.github.clothesstore.requests;

import com.github.clothesstore.model.Genders;

public class GendersRequest {
	
	public ValidationReturn insert(Genders obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getGender() == '0') {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'gender' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn update(Genders obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getGender() == '0') {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'gender' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteByGender(char gender) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (gender == '0') {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'gender' is missing");
		}
		
		return validationReturn;
	}
}
