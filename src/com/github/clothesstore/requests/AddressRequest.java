package com.github.clothesstore.requests;

import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Payment_methods;

public class AddressRequest {

	public ValidationReturn insert(Address obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getStreet().equals("") || obj.getStreet().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'street' is missing");
		}
		
		if (obj.getDistrict().equals("") || obj.getDistrict().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'district' is missing");
		}
		
		if (obj.getNumber().equals(0) || obj.getNumber() < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'number' is missing");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn update(Address obj) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (obj.getId().equals(0) || obj.getId() < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		if (
				(obj.getStreet().equals("") || obj.getStreet().equals("null")) &&
				(obj.getDistrict().equals("") || obj.getDistrict().equals("null")) &&
				(obj.getNumber().equals(0) || obj.getNumber() < 0) &&
				(obj.getNote().equals("") || obj.getNote().equals("null"))
			) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("missing data");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn update(Address obj, String mainItem) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (
				(obj.getStreet().equals("") || obj.getStreet().equals("null")) &&
				(obj.getDistrict().equals("") || obj.getDistrict().equals("null")) &&
				(obj.getNumber().equals(0) || obj.getNumber() < 0) &&
				(obj.getNote().equals("") || obj.getNote().equals("null"))
			) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("missing data");
		}
		
		if (mainItem.equals("") || mainItem.equals(0) || mainItem.equals("null") || mainItem.equals(null)) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("an item is missing to manage");
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
		
		if (id.equals(0) || id < 0) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'id' is missing");
		}
		
		return validationReturn;
	}
}
