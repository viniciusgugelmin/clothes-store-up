package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.AddressDAO;
import com.github.clothesstore.dao.Address_usersDAO;
import com.github.clothesstore.dao.DAOFactory;
import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Address;
import com.github.clothesstore.model.Payment_methods;
import com.github.clothesstore.model.Users;
import com.github.clothesstore.model.ValidationReturn;
import com.github.clothesstore.requests.AddressRequest;
import com.github.clothesstore.requests.Payment_methodsRequest;

public class AddressDAOJDBC implements AddressDAO {

	private AddressRequest validator = new AddressRequest();
	
	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Address obj) {
		ValidationReturn validation = validator.insert(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
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
		ValidationReturn validation = validator.update(obj);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		String valuesToUpdate = "";
		
		
		if (!obj.getStreet().isEmpty() && !obj.getStreet().equals("") && !obj.getStreet().equals("null")) {
			valuesToUpdate += ("street='" + obj.getStreet() + "'");
			
			if ( 
					(!obj.getDistrict().isEmpty() && !obj.getDistrict().equals("") && !obj.getDistrict().equals("null")) ||
					(obj.getNumber() > 0) ||
					(!obj.getNote().isEmpty() && !obj.getNote().equals("") && !obj.getNote().equals("null"))
				) {
				valuesToUpdate += ", ";
			}
		}
		
		if (!obj.getDistrict().isEmpty() && !obj.getDistrict().equals("") && !obj.getDistrict().equals("null")) {
			valuesToUpdate += ("district='" + obj.getDistrict() + "'");
			
			if ( 
					(obj.getNumber() > 0) ||
					(!obj.getNote().isEmpty() && !obj.getNote().equals("") && !obj.getNote().equals("null"))
				) {
				valuesToUpdate += ", ";
			}
		}
		
		if (obj.getNumber() > 0) {
			valuesToUpdate += ("number=" + obj.getNumber());
			
			if ( 
					(!obj.getNote().isEmpty() && !obj.getNote().equals("") && !obj.getNote().equals("null"))
				) {
				valuesToUpdate += ", ";
			}
		}
		
		if (!obj.getNote().isEmpty() && !obj.getNote().equals("") && !obj.getNote().equals("null")) {
			valuesToUpdate += ("note='" + obj.getNote() + "' ");
		}

		DAOJDBCModel.singleCall("UPDATE address SET " + valuesToUpdate + "WHERE " + obj.getId() + 
				"='" + obj.getId() + "';");
	}
	
	/*
	 * Update row from main item selected by user
	 */
	@Override
	public void update(Address obj, String mainItem, Address oldObj) {
		ValidationReturn validation = validator.update(obj, mainItem);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
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
				"='" + oldObj.getByString(mainItem) + "';");
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
		Address_usersDAO addressUserDAO = DAOFactory.createAddress_usersDAO();
		addressUserDAO.deleteById(id);
		// Delete dependencies
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM address WHERE id='" + id + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Address findById(Integer id) {
		ValidationReturn validation = validator.findById(id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM address WHERE id='" + id + "';", sqlStatement);
		
		try {
			if (item != null) {
				return new Address(item.getInt("id"), item.getString("street"), item.getString("district"),
						item.getInt("number"), item.getString("note"));
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
