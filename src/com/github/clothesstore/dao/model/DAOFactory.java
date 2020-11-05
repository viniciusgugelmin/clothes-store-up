package com.github.clothesstore.dao.model;

import com.github.clothesstore.dao.AddressDAO;
import com.github.clothesstore.dao.Documents_typeDAO;
import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.impl.AddressDAOJDBC;
import com.github.clothesstore.dao.impl.Documents_typeDAOJDBC;
import com.github.clothesstore.dao.impl.GendersDAOJDBC;
import com.github.clothesstore.dao.impl.Payment_methodsDAOJDBC;

public class DAOFactory {
	
	public static Payment_methodsDAO createPayment_methodsDAO() {
		return new Payment_methodsDAOJDBC();
	}
	
	public static AddressDAO createAddressDAO() {
		return new AddressDAOJDBC();
	}
	
	public static GendersDAO createGendersDAO() {
		return new GendersDAOJDBC();
	}
	
	public static Documents_typeDAO createDocuments_typeDAO() {
		return new Documents_typeDAOJDBC();
	}
}
