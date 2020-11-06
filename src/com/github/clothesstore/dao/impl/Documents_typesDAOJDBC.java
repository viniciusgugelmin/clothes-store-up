package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Documents_typesDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Documents_types;
import com.github.clothesstore.model.Payment_methods;

public class Documents_typesDAOJDBC implements Documents_typesDAO {

	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Documents_types obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO documents_types (type) VALUES ('" + obj.getType() + "');");
	}

	/*
	 * Update row from table by id
	 */
	@Override
	public void update(Documents_types obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("UPDATE documents_types SET type='" + obj.getType() + "' WHERE id='" + obj.getId() + "';");
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM documents_types WHERE id='" + id + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Documents_types findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM documents_types WHERE id='" + id + "';", sqlStatement);
		
		try {
			return new Documents_types(item.getInt("id"), item.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
			DB.closeConnection();
		}
		
		return null;
	}

	/*
	 * Find all rows from table
	 */
	@Override
	public List<Documents_types> findAll() {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		List<Documents_types> arrayList = new ArrayList<>();
		
		ResultSet array = DAOJDBCModel.multiCallReturn("SELECT * FROM documents_types;", sqlStatement);
		
		try {
			while(array.next()) {
				arrayList.add(new Documents_types(array.getInt("id"), array.getString("type"))); 
			}
			
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
			DB.closeConnection();
		}
		
		return null;
	}
}
