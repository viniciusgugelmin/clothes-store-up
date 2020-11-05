package com.github.clothesstore.dao.impl.model;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.github.clothesstore.dao.Payment_methodsDAO;
import com.github.clothesstore.database.DB;
import com.github.clothesstore.model.Payment_methods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOJDBC {
	
	public void singleCall(String statementLine) {
		Connection connectionDatabase = null;
		PreparedStatement sqlStatement = null;
		
		try {
			connectionDatabase = DB.getConnection();
			sqlStatement = connectionDatabase.prepareStatement(
					statementLine,
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = sqlStatement.executeUpdate();
			
			// Development
			//
			if (rowsAffected > 0) {
				ResultSet resultSqlStatement = sqlStatement.getGeneratedKeys();
				System.out.println(statementLine);
		
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
	
	public ResultSet singleCallReturn(String statementLine, Statement sqlStatement) {
		Connection connectionDatabase = null;
		
		try {
			connectionDatabase = DB.getConnection();
			sqlStatement = connectionDatabase.createStatement();
			ResultSet resultStatement = sqlStatement.executeQuery(statementLine);
		
			System.out.println(statementLine);
			while(resultStatement.next()) {
				return resultStatement;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet multiCallReturn(String statementLine, Statement sqlStatement) {
		Connection connectionDatabase = null;
		
		try {
			connectionDatabase = DB.getConnection();
			sqlStatement = connectionDatabase.createStatement();
			ResultSet resultStatement = sqlStatement.executeQuery(statementLine);
			
			System.out.println(statementLine);
			return resultStatement;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}