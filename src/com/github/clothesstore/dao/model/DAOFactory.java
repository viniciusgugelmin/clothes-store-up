package com.github.clothesstore.dao.model;

import com.github.clothesstore.dao.AddressDAO;
import com.github.clothesstore.dao.Documents_typesDAO;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.Payment_methods_dataDAO;
import com.github.clothesstore.dao.impl.AddressDAOJDBC;
import com.github.clothesstore.dao.impl.Documents_typesDAOJDBC;
import com.github.clothesstore.dao.impl.GendersDAOJDBC;
import com.github.clothesstore.dao.impl.Payment_methodsDAOJDBC;
import com.github.clothesstore.dao.impl.Payment_methods_dataDAOJDBC;

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
}
