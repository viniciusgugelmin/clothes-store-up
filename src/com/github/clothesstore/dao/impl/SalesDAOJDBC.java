package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.ProductsDAO;
import com.github.clothesstore.dao.SalesDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Products;
import com.github.clothesstore.model.Sales;
import com.github.clothesstore.model.ValidationReturn;
import com.github.clothesstore.requests.ProductsRequest;
import com.github.clothesstore.requests.SalesRequest;

public class SalesDAOJDBC implements SalesDAO {
	
	private SalesRequest validator = new SalesRequest();

	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Sales obj) {
		ValidationReturn validation = validator.associate(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO sales (product_id, buyer_id, created_at) "
				+ "VALUES (" + obj.getProduct_id() + ", " + obj.getBuyer_id() + ", '" +  obj.getCreated_at() + "');");
	}

	/*
	 * Delete row from table by product_id
	 */
	@Override
	public void deleteByProductId(Integer product_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM products WHERE product_id=" + product_id + ";");
	}

	/*
	 * Delete row from table by buyer_id
	 */
	@Override
	public void deleteByBuyerId(Integer buyer_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM sales WHERE buyer_id=" + buyer_id + ";");
	}

	/*
	 * Find row from table by product_id
	 */
	@Override
	public List<Sales> findByProductId(Integer product_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Sales> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM sales WHERE product_id=" + product_id + ";", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Sales(array.getInt("product_id"), array.getInt("buyer_id"), array.getString("created_at")));
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
	 * Find row from table by buyer_id
	 */
	@Override
	public List<Sales> findByBuyerId(Integer buyer_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Sales> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM sales WHERE buyer_id=" + buyer_id + ";", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Sales(array.getInt("product_id"), array.getInt("buyer_id"), array.getString("created_at")));
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
	public List<Sales> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Sales> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM sales;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Sales(array.getInt("product_id"), array.getInt("buyer_id"), array.getString("created_at")));
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
