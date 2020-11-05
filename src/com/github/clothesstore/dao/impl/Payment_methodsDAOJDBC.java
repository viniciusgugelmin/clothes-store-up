package com.github.clothesstore.dao.impl;


import java.sql.Connection;

import java.util.List;

import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Payment_methods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment_methodsDAOJDBC implements Payment_methodsDAO {

	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Payment_methods obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO payment_methods (type) VALUES ('" + obj.getType() + "');");
	}

	/*
	 * Update row from table by id
	 */
	@Override
	public void update(Payment_methods obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("UPDATE payment_methods SET type='" + obj.getType() + "' WHERE id='" + obj.getId() + "';");
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM payment_methods WHERE id='" + id + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Payment_methods findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM payment_methods WHERE id='" + id + "';", sqlStatement);
		
		try {
			return new Payment_methods(item.getInt("id"), item.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
			DB.closeConnection();
		}
		
		return null;
	}

	@Override
	public List<Payment_methods> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
