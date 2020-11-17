package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Products_typesDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Products_types;
import com.github.clothesstore.model.ValidationReturn;
import com.github.clothesstore.requests.Products_typesRequest;

public class Products_typesDAOJDBC implements Products_typesDAO {
	
	private Products_typesRequest validator = new Products_typesRequest();

	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Products_types obj) {
		ValidationReturn validation = validator.associate(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO products_types (type, gender, size) "
				+ "VALUES ('" + obj.getType() + "', '" + obj.getGender() + "', '" +  obj.getSize() + "');");
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM products_types WHERE id=" + id + ";");
	}

	/*
	 * Delete row from table by gender
	 */
	@Override
	public void deleteByGender(char gender) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM products_types WHERE gender='" + gender + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Products_types findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM products_types WHERE id=" + id + ";", sqlStatement);
		
		try {
			if (item != null) {
				return new Products_types(item.getInt("id"), item.getString("type"), item.getString("gender").charAt(0), item.getString("size"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
		}
		
		return null;
	}

	/*
	 * Find row from table by type
	 */
	@Override
	public List<Products_types> findByType(String type) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Products_types> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM products_types WHERE type='" + type + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Products_types(array.getInt("id"), array.getString("type"), array.getString("gender").charAt(0), array.getString("size"))); 
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
	 * Find row from table by gender
	 */
	@Override
	public List<Products_types> findByGender(char gender) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Products_types> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM products_types WHERE gender='" + gender + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Products_types(array.getInt("id"), array.getString("type"), array.getString("gender").charAt(0), array.getString("size"))); 
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
	 * Find row from table by size
	 */
	@Override
	public List<Products_types> findBySize(String size) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Products_types> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM products_types WHERE size='" + size + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Products_types(array.getInt("id"), array.getString("type"), array.getString("gender").charAt(0), array.getString("size"))); 
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
	public List<Products_types> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Products_types> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM products_types;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Products_types(array.getInt("id"), array.getString("type"), array.getString("gender").charAt(0), array.getString("size"))); 
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
