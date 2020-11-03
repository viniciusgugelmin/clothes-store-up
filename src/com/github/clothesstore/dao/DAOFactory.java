package com.github.clothesstore.dao;

import com.github.clothesstore.dao.impl.Payment_methodsDAOJDBC;

public class DAOFactory {
	
	public static Payment_methodsDAO createPayment_methodsDAO() {
		return new Payment_methodsDAOJDBC();
	}
}
