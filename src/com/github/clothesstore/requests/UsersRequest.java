package com.github.clothesstore.requests;

import com.github.clothesstore.dao.Documents_typesDAO;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.model.Documents_types;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.model.Users;

public class UsersRequest {
	
	public ValidationReturn associate(Users obj, char gender, Integer document_id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		GendersDAO genderDAO = DAOFactory.createGendersDAO();
		Genders genderItem = genderDAO.findByGender(gender);
		
		System.out.println(genderItem);
		
		if (genderItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("gender not found");
			
			return validationReturn;
		}
		
		Documents_typesDAO documentTypeDAO = DAOFactory.createDocuments_typesDAO();
		Documents_types documentType = documentTypeDAO.findById(document_id);
		
		System.out.println(documentType);
		
		if (documentType == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("document_type not found");
			
			return validationReturn;
		}
		
		if (obj.getDocument().equals("") || obj.getDocument().equals("null") || obj.getDocument().length() > 14) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'document' invalid");
		}
		
		if (obj.getName().equals("") || obj.getName().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'name' is missing");
		}
		
		if (obj.getEmail().equals("") || obj.getEmail().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'email' is missing");
		}
		
		if (obj.getDdi().equals("") || obj.getDdi().equals("null") || obj.getDdi().length() > 4) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'ddi' invalid");
		}
		
		if (obj.getDdd().equals("") || obj.getDdd().equals("null") || obj.getDdd().length() > 2) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'ddd' invalid");
		}
		
		if (obj.getPhone().equals("") || obj.getPhone().equals("null") || obj.getPhone().length() > 20) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'phone' invalid");
		}
		
		if (obj.getPassword().equals("") || obj.getPassword().equals("null") || obj.getPassword().length() > 100 || obj.getPassword().length() < 4) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'password' invalid");
		}

		return validationReturn;
	}
	
	public ValidationReturn update(Users obj, String oldDocument) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (
				obj.getDocument().equals("") || obj.getDocument().equals("null") || obj.getDocument().length() > 14 ||
				oldDocument.equals("") || oldDocument.equals("null") || oldDocument.length() > 14
			) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'document' invalid");
		}
		
		if (obj.getName().equals("") || obj.getName().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'name' is missing");
		}
		
		if (obj.getEmail().equals("") || obj.getEmail().equals("null")) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'email' is missing");
		}
		
		if (obj.getDdi().equals("") || obj.getDdi().equals("null") || obj.getDdi().length() > 4) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'ddi' invalid");
		}
		
		if (obj.getDdd().equals("") || obj.getDdd().equals("null") || obj.getDdd().length() > 2) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'ddd' invalid");
		}
		
		if (obj.getPhone().equals("") || obj.getPhone().equals("null") || obj.getPhone().length() > 20) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'phone' invalid");
		}
		
		if (obj.getPassword().equals("") || obj.getPassword().equals("null") || obj.getPassword().length() > 100 || obj.getPassword().length() < 4) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'password' invalid");
		}

		return validationReturn;
	}
	
	public ValidationReturn deleteByDocument(String document) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		if (document.equals("") || document.equals("null") || document.length() > 14) {
			validationReturn.setStatus(422);
			validationReturn.setResponse("'document' invalid");
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteByGender(char gender) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		GendersDAO genderDAO = DAOFactory.createGendersDAO();
		Genders genderItem = genderDAO.findByGender(gender);
		
		System.out.println(genderItem);
		
		if (genderItem == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("gender not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
	
	public ValidationReturn deleteByDocumentId(Integer document_id) {
		ValidationReturn validationReturn = new ValidationReturn();
		
		Documents_typesDAO documentTypeDAO = DAOFactory.createDocuments_typesDAO();
		Documents_types documentType = documentTypeDAO.findById(document_id);
		
		System.out.println(documentType);
		
		if (documentType == null) {
			validationReturn.setStatus(404);
			validationReturn.setResponse("document_type not found");
			
			return validationReturn;
		}
		
		return validationReturn;
	}
}
