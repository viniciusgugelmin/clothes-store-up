package com.github.clothesstore.dao.impl;


import java.sql.Connection;

import java.util.List;

import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Payment_methods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment_methodsDAOJDBC implements Payment_methodsDAO {

	@Override
	public void insert(Payment_methods obj) {
		Connection connectionDatabase = null;
		PreparedStatement sqlStatement = null;
		
		try {
			connectionDatabase = DB.getConnection();
			sqlStatement = connectionDatabase.prepareStatement(
					"INSERT INTO payment_methods (type) VALUES ('" + obj.getType() + "')",
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			// Development
			//
			if (rowsAffected > 0) {
				ResultSet resultSqlStatement = sqlStatement.getGeneratedKeys();

				while(resultSqlStatement.next()) {
					int id = resultSqlStatement.getInt(1);
					
					System.out.println("New row! [Id = " + id + "]");
				}
			} else {
				System.out.println("No rows affected");
			}
			//
			// Development
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			DB.closeStatament(sqlStatement);
			DB.closeConnection();
		}
	}

	@Override
	public void update(Payment_methods obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment_methodsDAO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment_methods> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
