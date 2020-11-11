package com.github.clothesstore.app;

import com.github.clothesstore.dao.AddressDAO;
import com.github.clothesstore.dao.Documents_typesDAO;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.Payment_methods_dataDAO;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Documents_types;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;

public class Programa {
	
	public static void main(String[] args) {
		
		/*
		 * Payment_methods
		 */
		System.out.println("payment_methods");
		
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
		//paymentMethodDAO.deleteById(1);
		
		// findAll
		//System.out.println(paymentMethodDAO.findAll());
		
		// deleteById
		//paymentMethodDAO.deleteById(2);
		
		// findAll
		//System.out.println(paymentMethodDAO.findAll());
		
		/*
		 * Payment_methods_data
		 */
		System.out.println("\npayment_methods_data");
		
		Payment_methods_data paymentMethodData = new Payment_methods_data();
		Payment_methods_dataDAO paymentMethodDataDAO = DAOFactory.createPayment_methods_dataDAO();
		
		// associate
		paymentMethodDataDAO.associate(paymentMethodData, 2);
		
		// findById
		System.out.println(paymentMethodDataDAO.findById(1));
		
		// findByType
		System.out.println(paymentMethodDataDAO.findByType(2));
		
		// associate
		paymentMethodData.setCard_number("5396012726349596");
		paymentMethodData.setExpiry_date("10-2021");
		paymentMethodData.setCvc("954");
		paymentMethodDataDAO.associate(paymentMethodData, 1);
				
		// findById
		System.out.println(paymentMethodDataDAO.findById(2));
				
		// findByType
		System.out.println(paymentMethodDataDAO.findByType(1));
		
		// findByType
		System.out.println(paymentMethodDataDAO.findAll());
		
		// deleteById
		paymentMethodDataDAO.deleteById(1);
		
		// deleteByType
		paymentMethodDataDAO.deleteByType(1);
		
		/*
		 * Documents_types
		 */
		System.out.println("\ndocuments_types");
		
		Documents_types documentsType = new Documents_types();
		Documents_typesDAO documentsTypeDAO = DAOFactory.createDocuments_typesDAO();
		
		// insert
		documentsType.setType("CPF");
		documentsTypeDAO.insert(documentsType);
		
		// findById
		System.out.println(documentsTypeDAO.findById(1));
		
		// update
		documentsType.setId(1);
		documentsType.setType("CNPJ");
		documentsTypeDAO.update(documentsType);
		
		// findById
		System.out.println(documentsTypeDAO.findById(1));
		
		// insert
		documentsType.setType("CPF");
		documentsTypeDAO.insert(documentsType);
		
		// findAll
		System.out.println(documentsTypeDAO.findAll());
		
		// deleteById
		documentsTypeDAO.deleteById(1);
		
		// findAll
		System.out.println(documentsTypeDAO.findAll());
		
		// deleteById
		documentsTypeDAO.deleteById(2);
		
		// findAll
		System.out.println(documentsTypeDAO.findAll());
		
		/*
		 * Address
		 */
		System.out.println("\naddress");
		
		Address address = new Address();
		AddressDAO addressDAO = DAOFactory.createAddressDAO();
		
		// insert
		address.setStreet("Travessa Célia Cardozo dos Santos");
		address.setDistrict("Alto Boqueirão");
		address.setNumber(1000);
		addressDAO.insert(address);
		
		// findById
		System.out.println(addressDAO.findById(1));
		
		// update
		address.setId(1);
		address.setStreet("Rua Piraquara");
		address.setDistrict("Sítio Cercado");
		address.setNote("AP 15");
		addressDAO.update(address);
		
		// findById
		System.out.println(addressDAO.findById(1));
		
		// insert
		address.setStreet("Travessa Célia Cardozo dos Santos");
		address.setDistrict("Alto Boqueirão");
		address.setNumber(1000);
		address.setNote("");
		addressDAO.insert(address);
		
		// findAll
		System.out.println(addressDAO.findAll());
		
		// deleteById
		addressDAO.deleteById(1);
		
		// findAll
		System.out.println(addressDAO.findAll());
		
		// deleteById
		addressDAO.deleteById(2);
		
		// findAll
		System.out.println(addressDAO.findAll());
		
		/*
		 * Genders
		 */
		System.out.println("\ngenders");
		
		Genders genders = new Genders();
		GendersDAO gendersDAO = DAOFactory.createGendersDAO();
		
		// insert
		genders.setGender('M');
		gendersDAO.insert(genders);
		
		// findAll
		System.out.println(gendersDAO.findAll());
		
		// update
		genders.setGender('F');
		gendersDAO.update(genders, 'M');
		
		// findAll
		System.out.println(gendersDAO.findAll());
		
		// insert
		genders.setGender('M');
		gendersDAO.insert(genders);
		
		// findAll
		System.out.println(gendersDAO.findAll());
		
		// deleteById
		gendersDAO.deleteByGender('F');
		
		// findAll
		System.out.println(gendersDAO.findAll());
		
		// deleteById
		gendersDAO.deleteByGender('M');
		
		// findAll
		System.out.println(gendersDAO.findAll());
		
		/*
		 * CLOSE CONNECTION
		 */
		
		DB.closeConnection();
	}
}