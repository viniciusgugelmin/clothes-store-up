package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;


import dbConnection.DB;
import dbConnection.DbIntegrityException;

public class Programa {
/*
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		try {
			// Connect to the database
			conn = DB.getConnection();

			st = conn.prepareStatement(" DELETE FROM payment_methods " + " WHERE " + " Id = ?");

			st.setInt(1, 7);

			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows Affected :" + rowsAffected);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatament(st);
			DB.closeConnection();
		}

	}
*/
	
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"insert into payment_methods (type) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS	);
			// Quantas linhas foram afetadas rows affected
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
				
			}else {
				System.out.println(" No rows affected");
			}
		} catch (SQLException e) {
			e.printStackTrace( );
		}  finally {
			DB.closeStatament(st);
			DB.closeConnection();
		}

	}
	
	
}
