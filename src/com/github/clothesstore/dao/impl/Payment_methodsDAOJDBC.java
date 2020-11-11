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
import com.github.clothesstore.requests.Payment_methodsRequest;
import com.github.clothesstore.requests.ValidationReturn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment_methodsDAOJDBC implements Payment_methodsDAO {
	
	private Payment_methodsRequest validator = new Payment_methodsRequest();

	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Payment_methods obj) {
		ValidationReturn validation = validator.insert(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO payment_methods (type) VALUES ('" + obj.getType() + "');");
	}

	/*
	 * Update row from table by id
	 */
	@Override
	public void update(Payment_methods obj) {
		ValidationReturn validation = validator.update(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("UPDATE payment_methods SET type='" + obj.getType() + "' WHERE id='" + obj.getId() + "';");
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
		
		// Delete dependencies
		Payment_methods_dataDAO paymentMethodDAO = DAOFactory.createPayment_methods_dataDAO();
		paymentMethodDAO.deleteByType(id);
		// Delete dependencies
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM payment_methods WHERE id='" + id + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Payment_methods findById(Integer id) {
		ValidationReturn validation = validator.findById(id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM payment_methods WHERE id='" + id + "';", sqlStatement);

		try {
			if (item != null) {
				return new Payment_methods(item.getInt("id"), item.getString("type"));
			}
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
	public List<Payment_methods> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Payment_methods> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM payment_methods;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Payment_methods(array.getInt("id"), array.getString("type"))); 
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
