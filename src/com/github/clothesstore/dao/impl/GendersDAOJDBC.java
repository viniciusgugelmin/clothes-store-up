package com.github.clothesstore.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.GendersDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Genders;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Users;
import com.github.clothesstore.requests.Documents_typesRequest;
import com.github.clothesstore.requests.GendersRequest;
import com.github.clothesstore.requests.ValidationReturn;

public class GendersDAOJDBC implements GendersDAO {

	private GendersRequest validator = new GendersRequest();
	
	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Genders obj) {
		ValidationReturn validation = validator.insert(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO genders (gender) VALUES ('" + obj.getGender() + "');");
	}
	
	/*
	 * Update row from table by gender
	 */
	@Override
	public void update(Genders obj, char oldGender) {
		ValidationReturn validation = validator.update(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("UPDATE genders SET gender='" + obj.getGender() + "' WHERE gender='" + oldGender + "';");
	}
	
	/*
	 * Delete row from table by gender
	 */
	@Override
	public void deleteByGender(char gender) {
		ValidationReturn validation = validator.deleteByGender(gender);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM genders WHERE gender='" + gender + "';");
	}
	
	/*
	 * Find row from table by document
	 */
	@Override
	public Genders findByGender(char gender) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM genders WHERE gender='" + gender + "';", sqlStatement);
		
		try {
			if (item != null) {
				return new Genders(item.getString("gender").charAt(0));
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
	public List<Genders> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Genders> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM genders;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Genders(array.getString("gender").charAt(0))); 
			}
			
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
		}
		
		return null;
	}

	@Override
	public void update(Genders obj) {
		// TODO Auto-generated method stub
		
	}
}
	

