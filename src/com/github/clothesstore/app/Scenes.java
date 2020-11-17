package com.github.clothesstore.app;

import com.github.clothesstore.model.*;
import com.github.clothesstore.dao.*;

public class Scenes {

	public static void Address() {

		System.out.println("address");
		
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
		//addressDAO.deleteById(1);
		
		// findAll
		//System.out.println(addressDAO.findAll());
		
		// deleteById
		//addressDAO.deleteById(2);
		
		// findAll
		//System.out.println(addressDAO.findAll());
	}
	
	public static void Genders() {
		
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
		//gendersDAO.deleteByGender('F');
		
		// findAll
		//System.out.println(gendersDAO.findAll());
		
		// deleteById
		//gendersDAO.deleteByGender('M');
		
		// findAll
		//System.out.println(gendersDAO.findAll());
	}
	
	public static void Documents_types() {

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
		//documentsTypeDAO.deleteById(1);
		
		// findAll
		//System.out.println(documentsTypeDAO.findAll());
		
		// deleteById
		//documentsTypeDAO.deleteById(2);
		
		// findAll
		//System.out.println(documentsTypeDAO.findAll());
	}
	
	public static void Users() {

		System.out.println("\nusers");
		
		Users user = new Users();
		UsersDAO userDAO = DAOFactory.createUsersDAO();
		
		// associate
		user.setDocument("42167367007");
		user.setDocument_id(2);
		user.setDdi("55");
		user.setDdd("41");
		user.setPhone("123456789");
		user.setEmail("teste@hotmail.com");
		user.setName("Teste da Silva");
		user.setPassword("123456789");
		user.setGender('M');
		userDAO.associate(user, 'M', 2);
		
		// findByDocument
		System.out.println(userDAO.findByDocument("42167367007"));
		
		// update
		user.setDocument("02167367007");
		user.setName("Testonio dos Santos");
		userDAO.update(user, "42167367007");
		
		// findAll
		System.out.println(userDAO.findAll());
	}
	
	public static void Address_users() {

		System.out.println("\naddress_users");
		
		Address_users adddressUser = new Address_users();
		Address_usersDAO adddressUserDAO = DAOFactory.createAddress_usersDAO();
		
		// associate
		adddressUserDAO.associate(2, "02167367007");
		
		// associate
		adddressUserDAO.associate(1, "02167367007");
		
		// findAll
		System.out.println(adddressUserDAO.findAll());
	}
	
	public static void Payment_methods() {

		System.out.println("\npayment_methods");
		
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
	}
	
	public static void Payment_methods_data() {

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
		
		// findAll
		System.out.println(paymentMethodDataDAO.findAll());
		
		// deleteById
		//paymentMethodDataDAO.deleteById(1);
		
		// deleteByType
		//paymentMethodDataDAO.deleteByType(1);
	}
	
	public static void Users_payment_methods_data() {

		System.out.println("\nusers_payment_methods_data");
		
		Users_payment_methods_data userPaymentMethodData = new Users_payment_methods_data();
		Users_payment_methods_dataDAO userPaymentMethodDataDAO = DAOFactory.createUsers_payment_methods_dataDAO();

		// associate
		userPaymentMethodDataDAO.associate(1, "02167367007");
		
		// findAll
		System.out.println(userPaymentMethodDataDAO.findAll());
	}
	
	public static void Products_types() {
		
		System.out.println("\nproducts_types");
		
		Products_types productType = new Products_types();
		Products_typesDAO productTypeDAO = DAOFactory.createProducts_typesDAO();
		
		// associate
		productType.setGender('M');
		productType.setSize("XG");
		productType.setType("Shirt");
		productTypeDAO.associate(productType);
		
		// findAll
		System.out.println(productTypeDAO.findAll());
	}
}
