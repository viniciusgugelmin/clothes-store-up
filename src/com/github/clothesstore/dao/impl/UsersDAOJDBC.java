package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Address_usersDAO;
import com.github.clothesstore.dao.Payment_methods_dataDAO;
import com.github.clothesstore.dao.UsersDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.dao.model.DAOFactory;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.database.DBException;
import com.github.clothesstore.model.Users;
import com.github.clothesstore.requests.UsersRequest;
import com.github.clothesstore.requests.ValidationReturn;

public class UsersDAOJDBC implements UsersDAO {

	private UsersRequest validator = new UsersRequest();
	
	/* 
	 * Insert values into table and associate
	 */
	@Override
	public void associate(Users obj, char gender, Integer document_id) {
		ValidationReturn validation = validator.associate(obj, gender, document_id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO users (document, document_id, name, email, ddi, ddd, phone, password, gender) VALUES ('" + obj.getDocument() + "'," 
		+ document_id + ",'" + obj.getName() + "','" + obj.getEmail() + "','" + obj.getDdi() + "','" + obj.getDdd() + "','" + obj.getPhone() + "','" +
		obj.getPassword() + "','" + gender + "');");	
	}

	/*
	 * Update row from table by document
	 */
	@Override
	public void update(Users obj, String oldDocument) {
		ValidationReturn validation = validator.update(obj, oldDocument);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("UPDATE users SET document='" + obj.getDocument() + "', document_id='" + obj.getDocument_id() + "', name='" + obj.getName() + "', email='" 
		+ obj.getEmail() + "', ddi='" + obj.getDdi() + "', ddd='" + obj.getDdd() + "', phone='" + obj.getPhone() + "', password='" + obj.getPassword() + "', gender='" + obj.getGender() + "' WHERE document='" + oldDocument + "';");
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
		
		DAOJDBCModel.singleCall("DELETE FROM users WHERE document='" + document + "';");
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
		
		DAOJDBCModel.singleCall("DELETE FROM users WHERE gender='" + gender + "';");
	}

	/*
	 * Delete row from table by document_id
	 */
	@Override
	public void deleteByDocumentId(Integer document_id) {
		ValidationReturn validation = validator.deleteByDocumentId(document_id);
		
		if (!validation.getStatus().equals(200)) {
			throw new DBException(validation.toString());
		}
		
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM users WHERE document_id=" + document_id + ";");
	}

	/*
	 * Find row from table by document
	 */
	@Override
	public Users findByDocument(String document) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM users WHERE document='" + document + "';", sqlStatement);
		
		try {
			if (item != null) {
				return new Users(item.getString("document"), item.getInt("document_id"), item.getString("name"), item.getString("email"),
						item.getString("ddi"), item.getString("ddd"), item.getString("phone"), item.getString("password"), item.getString("gender").charAt(0));
			}
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
	public List<Users> findByGender(char gender) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users WHERE gender='" + gender + "';", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users(array.getString("document"), array.getInt("document_id"), array.getString("name"), array.getString("email"),
						array.getString("ddi"), array.getString("ddd"), array.getString("phone"), array.getString("password"), array.getString("gender").charAt(0))); 
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
	 * Find row from table by document_id
	 */
	@Override
	public List<Users> findByDocumentId(Integer document_id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users WHERE document_id=" + document_id + ";", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users(array.getString("document"), array.getInt("document_id"), array.getString("name"), array.getString("email"),
						array.getString("ddi"), array.getString("ddd"), array.getString("phone"), array.getString("password"), array.getString("gender").charAt(0))); 
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
	public List<Users> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Users> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM users;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Users(array.getString("document"), array.getInt("document_id"), array.getString("name"), array.getString("email"),
						array.getString("ddi"), array.getString("ddd"), array.getString("phone"), array.getString("password"), array.getString("gender").charAt(0))); 
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
