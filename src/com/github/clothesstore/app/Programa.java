package com.github.clothesstore.app;

import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Payment_methods;

public class Programa {
	
	public static void main(String[] args) {
		
		/*
		 * Payment_methods
		 */
		
		Payment_methods paymentMethod = new Payment_methods();
		Payment_methodsDAO paymentMethodDAO = DAOFactory.createPayment_methodsDAO();
		
		// insert
		paymentMethod.setType("BANK_SLIP");
		paymentMethodDAO.insert(paymentMethod);
		
		// findById
		System.out.println(paymentMethodDAO.findById(1));
		
		// update
		paymentMethod.setId(1);
		paymentMethod.setType("CREDIT_CARD");
		paymentMethodDAO.update(paymentMethod);
		
		// findById
		System.out.println(paymentMethodDAO.findById(1));
		
		// insert
		paymentMethod.setType("BANK_SLIP");
		paymentMethodDAO.insert(paymentMethod);
		
		// findAll
		System.out.println(paymentMethodDAO.findAll());
		
		// deleteById
		paymentMethodDAO.deleteById(1);
		
		// findAll
		System.out.println(paymentMethodDAO.findAll());
		
		// deleteById
		paymentMethodDAO.deleteById(2);
		
		// findAll
		System.out.println(paymentMethodDAO.findAll());
		
		/*
		 * CLOSE CONNECTION
		 */
		
		DB.closeConnection();
	}
}