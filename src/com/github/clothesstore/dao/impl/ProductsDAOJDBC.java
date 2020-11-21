package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.ProductsDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Products;
import com.github.clothesstore.model.ValidationReturn;
import com.github.clothesstore.requests.ProductsRequest;

public class ProductsDAOJDBC implements ProductsDAO {
	
	private ProductsRequest validator = new ProductsRequest();

	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Products obj) {
		ValidationReturn validation = validator.associate(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO products (type_id, name, brand, price, discount, quantity_stock) "
				+ "VALUES (" + obj.getType_id() + ", '" + obj.getName() + "', '" +  obj.getBrand() + "', " + 
				obj.getPrice() + ", " + obj.getDiscount() + ", " + obj.getQuantity_stock() + ");");
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM products WHERE id=" + id + ";");
	}

	/*
	 * Delete row from table by type_id
	 */
	@Override
	public void deleteByType_id(Integer type_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM products WHERE type_id=" + type_id + ";");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Products findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM products WHERE id=" + id + ";", sqlStatement);
		
		try {
			if (item != null) {
				return new Products(item.getInt("id"), item.getInt("type_id"), item.getString("name"), item.getString("brand"), item.getFloat("price"), item.getFloat("discount"), item.getInt("quantity_stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
		}
		
		return null;
	}

	/*
	 * Find row from table by type_id
	 */
	@Override
	public List<Products> findType_id(Integer type_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Products> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM products WHERE type_id=" + type_id + ";", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Products(array.getInt("id"), array.getInt("type_id"), array.getString("name"), array.getString("brand"), array.getFloat("price"), array.getFloat("discount"), array.getInt("quantity_stock")));
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
	public List<Products> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Products> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM products;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Products(array.getInt("id"), array.getInt("type_id"), array.getString("name"), array.getString("brand"), array.getFloat("price"), array.getFloat("discount"), array.getInt("quantity_stock")));
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
