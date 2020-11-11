package com.github.clothesstore.dao.impl;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.Payment_methods_dataDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Payment_methods_data;
import com.github.clothesstore.requests.Payment_methodsRequest;
import com.github.clothesstore.requests.Payment_methods_dataRequest;
import com.github.clothesstore.requests.ValidationReturn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment_methods_dataDAOJDBC implements Payment_methods_dataDAO {
	
	private Payment_methods_dataRequest validator = new Payment_methods_dataRequest();

	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Payment_methods_data obj, Integer payment_method_type) {
		ValidationReturn validation = validator.associate(obj, payment_method_type);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();

		if (validation.getResponse().equals("CREDIT_CARD")) {
			DAOJDBCModel.singleCall("INSERT INTO payment_methods_data (payment_method_type, card_number, expiry_date, cvc)"
					+ " VALUES ('" + payment_method_type + "','" + obj.getCard_number()  + "','" + obj.getExpiry_date() + "','" + obj.getCvc() + "');");
		} else if (validation.getResponse().equals("BANK_SLIP")) {
			DAOJDBCModel.singleCall("INSERT INTO payment_methods_data (payment_method_type) VALUES ('" + payment_method_type + "');");
		}
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		ValidationReturn validation = validator.deleteById(id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM payment_methods_data WHERE id='" + id + "';");
	}

	/*
	 * Delete row from table by payment_method_type
	 */
	@Override
	public void deleteByType(Integer payment_method_type) {
		ValidationReturn validation = validator.deleteByType(payment_method_type);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM payment_methods_data WHERE payment_method_type='" + payment_method_type + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Payment_methods_data findById(Integer id) {
		ValidationReturn validation = validator.findById(id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM payment_methods_data WHERE id='" + id + "';", sqlStatement);
		
		try {
			if (item != null) {
				return new Payment_methods_data(item.getInt("id"), item.getInt("payment_method_type"), item.getString("card_number"), item.getString("expiry_date"), item.getString("cvc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
		}
		
		return null;
	}

	/*
	 * Find row from table by payment_method_type
	 */
	@Override
	public List<Payment_methods_data> findByType(Integer payment_method_type) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Payment_methods_data> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM payment_methods_data WHERE payment_method_type='" + payment_method_type + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Payment_methods_data(array.getInt("id"), array.getInt("payment_method_type"), array.getString("card_number"), array.getString("expiry_date"), array.getString("cvc"))); 
			}
			
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
		}
		
		return null;
	}

	/*
	 * Find all rows from table
	 */
	@Override
	public List<Payment_methods_data> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Payment_methods_data> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM payment_methods_data;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Payment_methods_data(array.getInt("id"), array.getInt("payment_method_type"), array.getString("card_number"), array.getString("expiry_date"), array.getString("cvc"))); 
			}
			
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
		}
		
		return null;
	}

	
}
