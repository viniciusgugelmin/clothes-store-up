package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Address_usersDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Address_users;
import com.github.clothesstore.model.ValidationReturn;
import com.github.clothesstore.requests.Address_usersRequest;

public class Address_usersDAOJDBC implements Address_usersDAO {

	private Address_usersRequest validator = new Address_usersRequest();
	
	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Integer id_address, String document_user) {
		ValidationReturn validation = validator.associate(id_address, document_user);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO address_users (id_address, document_user) "
				+ "VALUES (" + id_address + ", '" + document_user + "');");
	}

	/*
	 * Delete row from table by document
	 */
	@Override
	public void deleteByDocument(String document) {
		ValidationReturn validation = validator.deleteByDocument(document);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM address_users WHERE document_user='" + document + "';");
	}

	/*
	 * Delete row from table by id_address
	 */
	@Override
	public void deleteById(Integer id_address) {
		ValidationReturn validation = validator.deleteById(id_address);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM address_users WHERE id_address=" + id_address + ";");
	}

	/*
	 * Find row from table by document
	 */
	@Override
	public List<Address_users> findByDocument(String document) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Address_users> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM address_users WHERE document_user='" + document + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Address_users(array.getInt("id_address"), array.getString("document_user"))); 
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
	 * Find row from table by id_address
	 */
	@Override
	public List<Address_users> findById(Integer id_address) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Address_users> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM address_users WHERE id_address='" + id_address + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Address_users(array.getInt("id_address"), array.getString("document_user"))); 
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
	public List<Address_users> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Address_users> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM address_users;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Address_users(array.getInt("id_address"), array.getString("document_user"))); 
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
