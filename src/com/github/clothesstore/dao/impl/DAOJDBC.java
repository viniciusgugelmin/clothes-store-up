package com.github.clothesstore.dao.impl;


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
	
	/*
	 * Function for single calls without return
	 */
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
			System.out.println(statementLine);
			if (rowsAffected > 0) {
				ResultSet resultSqlStatement = sqlStatement.getGeneratedKeys();
		
			} else {
				System.out.println("No rows affected");
			}
			//
			// Development
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			DB.closeStatament(sqlStatement);
		}
	}
	
	/*
	 * Function for single calls with return
	 */
	public ResultSet singleCallReturn(String statementLine, Statement sqlStatement) {
		Connection connectionDatabase = null;
		
		try {
			connectionDatabase = DB.getConnection();
			sqlStatement = connectionDatabase.createStatement();
			ResultSet resultStatement = sqlStatement.executeQuery(statementLine);
		
			System.out.println(statementLine);
			
			if (resultStatement.isBeforeFirst()) {
				while(resultStatement.next()) {
					return resultStatement;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * Function for multi calls with return
	 */
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