package com.github.clothesstore.dao;

import com.github.clothesstore.dao.impl.*;

public class DAOFactory {
	
	public static Payment_methodsDAO createPayment_methodsDAO() {
		return new Payment_methodsDAOJDBC();
	}
	
	public static Payment_methods_dataDAO createPayment_methods_dataDAO() {
		return new Payment_methods_dataDAOJDBC();
	}
	
	public static AddressDAO createAddressDAO() {
		return new AddressDAOJDBC();
	}
	
	public static GendersDAO createGendersDAO() {
		return new GendersDAOJDBC();
	}
	
	public static Documents_typesDAO createDocuments_typesDAO() {
		return new Documents_typesDAOJDBC();
	}
	
	public static UsersDAO createUsersDAO() {
		return new UsersDAOJDBC();
	}

	public static Address_usersDAO createAddress_usersDAO() {
		return new Address_usersDAOJDBC();
	}
	
	public static Users_payment_methods_dataDAO createUsers_payment_methods_dataDAO() {
		return new Users_payment_methods_dataDAOJDBC();
	}
	
	public static Products_typesDAO createProducts_typesDAO() {
		return new Products_typesDAOJDBC();
	}
}
