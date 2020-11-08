package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.AddressDAO;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Payment_methods;

public class AddressDAOJDBC implements AddressDAO {

	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Address obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		String collumsToInsert = "street, district, number";
		String valuesToInsert = "'" + obj.getStreet() + "','" + obj.getDistrict() + "'," + obj.getNumber();
		
		if (!obj.getNote().isEmpty()) {
			collumsToInsert += ", note";
			valuesToInsert += (",'" + obj.getNote() + "'");
		}
		
		DAOJDBCModel.singleCall("INSERT INTO address (" + collumsToInsert + ") VALUES (" + valuesToInsert + ");");
	}

	@Override
	public void update(Address obj) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Update row from main item selected by user
	 */
	@Override
	public void update(Address obj, String mainItem) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		String valuesToUpdate = "";
		
		
		if (!obj.getStreet().isEmpty() && !obj.getStreet().equals("") && !obj.getStreet().equals("null")) {
			valuesToUpdate += ("street='" + obj.getStreet() + "' ");
		}
		
		if (!obj.getDistrict().isEmpty() && !obj.getDistrict().equals("") && !obj.getDistrict().equals("null")) {
			valuesToUpdate += ("district='" + obj.getDistrict() + "' ");
		}
		
		if (obj.getNumber() > 0) {
			valuesToUpdate += ("number=" + obj.getNumber() + " ");
		}
		
		if (!obj.getNote().isEmpty() && !obj.getNote().equals("") && !obj.getNote().equals("null")) {
			valuesToUpdate += ("note='" + obj.getNote() + "' ");
		}

		DAOJDBCModel.singleCall("UPDATE address SET " + valuesToUpdate + "WHERE " + mainItem + 
				"='" + obj.getByString(mainItem) + "';");
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM address WHERE id='" + id + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Address findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM address WHERE id='" + id + "';", sqlStatement);
		
		try {
			return new Address(item.getInt("id"), item.getString("street"), item.getString("district"),
					item.getInt("number"), item.getString("note"));
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
	public List<Address> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Address> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM address;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Address(array.getInt("id"), array.getString("street"), array.getString("district"),
						array.getInt("number"), array.getString("note"))); 
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
