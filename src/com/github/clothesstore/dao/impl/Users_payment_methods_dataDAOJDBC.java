package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Users_payment_methods_dataDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Users_payment_methods_data;
import com.github.clothesstore.requests.Users_payment_methods_dataRequest;
import com.github.clothesstore.requests.ValidationReturn;

public class Users_payment_methods_dataDAOJDBC implements Users_payment_methods_dataDAO {

	private Users_payment_methods_dataRequest validator = new Users_payment_methods_dataRequest();
	
	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Integer payment_method_data_id, String document_user) {
		ValidationReturn validation = validator.associate(payment_method_data_id, document_user);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO users_payment_methods_data (payment_method_data_id, user_document) "
				+ "VALUES (" + payment_method_data_id + ", '" + document_user + "');");
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
		
		DAOJDBCModel.singleCall("DELETE FROM users_payment_methods_data WHERE id=" + id + ";");
	}
	
	/*
	 * Delete row from table by user_document
	 */
	@Override
	public void deleteByDocument(String document) {
		ValidationReturn validation = validator.deleteByDocument(document);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM users_payment_methods_data WHERE user_document='" + document + "';");
	}

	/*
	 * Delete row from table by payment_method_data_id
	 */
	@Override
	public void deleteByPaymentMethodDataId(Integer payment_method_data_id) {
		ValidationReturn validation = validator.deleteByPaymentMethodDataId(payment_method_data_id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM users_payment_methods_data WHERE payment_method_data_id=" + payment_method_data_id + ";");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public List<Users_payment_methods_data> findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users_payment_methods_data> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users_payment_methods_data WHERE id=" + id + ";", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users_payment_methods_data(array.getInt("id"), array.getInt("payment_method_data_id"), array.getString("user_document"))); 
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
	 * Find row from table by user_document
	 */
	@Override
	public List<Users_payment_methods_data> findByDocument(String document) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users_payment_methods_data> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users_payment_methods_data WHERE user_document='" + document + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users_payment_methods_data(array.getInt("id"), array.getInt("payment_method_data_id"), array.getString("user_document"))); 
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
	 * Find row from table by payment_method_data_id
	 */
	@Override
	public List<Users_payment_methods_data> findByPaymentMethodDataId(Integer payment_method_data_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users_payment_methods_data> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users_payment_methods_data WHERE payment_method_data_id=" + payment_method_data_id + ";", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users_payment_methods_data(array.getInt("id"), array.getInt("payment_method_data_id"), array.getString("user_document"))); 
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
	public List<Users_payment_methods_data> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users_payment_methods_data> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users_payment_methods_data;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users_payment_methods_data(array.getInt("id"), array.getInt("payment_method_data_id"), array.getString("user_document"))); 
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