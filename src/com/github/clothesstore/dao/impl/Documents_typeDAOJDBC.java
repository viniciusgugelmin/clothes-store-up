package com.github.clothesstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.github.clothesstore.dao.Documents_typeDAO;
import com.github.clothesstore.dao.impl.model.DAOJDBC;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Documents_type;

public class Documents_typeDAOJDBC implements Documents_typeDAO {

	/* 
	 * Insert values into table
	 */
	@Override
	public void insert(Documents_type obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("INSERT INTO documents_type (type) VALUES ('" + obj.getType() + "');");
	}

	/*
	 * Update row from table by id
	 */
	@Override
	public void update(Documents_type obj) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("UPDATE documents_type SET type='" + obj.getType() + "' WHERE id='" + obj.getId() + "';");
	}

	/*
	 * Delete row from table by id
	 */
	@Override
	public void deleteById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		
		DAOJDBCModel.singleCall("DELETE FROM documents_type WHERE id='" + id + "';");
	}

	/*
	 * Find row from table by id
	 */
	@Override
	public Documents_type findById(Integer id) {
		DAOJDBC DAOJDBCModel = new DAOJDBC();
		Statement sqlStatement = null;
		
		ResultSet item = DAOJDBCModel.singleCallReturn("SELECT * FROM documents_type WHERE id='" + id + "';", sqlStatement);
		
		try {
			return new Documents_type(item.getInt("id"), item.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatament(sqlStatement);
			DB.closeConnection();
		}
		
		return null;
	}

	@Override
	public List<Documents_type> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
