package com.github.clothesstore.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMigration {

	public static void migrate(String nameFile, int jumpTrivialLines) {
		
		try {
			System.out.println(nameFile);
			BufferedReader bufferedReader = new BufferedReader(
					new FileReader("src/com/github/clothesstore/migrations/" + nameFile + ".sql"));
			
			Scanner sqlFile = new Scanner(bufferedReader);
			
			// Jump trivial lines
			int countTrivial = 0;
			while (countTrivial < jumpTrivialLines) {
				sqlFile.nextLine();
				countTrivial++;
			}
			
			String sqlQuery = "";
			
			while (sqlFile.hasNext()) {
				Connection connectionDatabase = null;
				PreparedStatement sqlStatement = null;
				
				sqlQuery += sqlFile.nextLine();
				
				if (sqlQuery.contains(";")) {
					try {
						connectionDatabase = DB.getConnection();
						System.out.println(sqlQuery);
						sqlStatement = connectionDatabase.prepareStatement(
								sqlQuery,
								Statement.RETURN_GENERATED_KEYS);
						
						int rowsAffected = sqlStatement.executeUpdate();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}  finally {
						DB.closeStatament(sqlStatement);
						sqlQuery = "";
					}
				}
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
	}
}
