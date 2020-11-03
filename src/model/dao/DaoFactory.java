package model.dao;

import model.dao.implementacao.payment_methods_dataDaoJDBC;

public class DaoFactory {
	
	public static Payment_methods_dataDao createPayment_methods_dataDao() {
		return new payment_methods_dataDaoJDBC();
	}

}
