package dbConnection;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class DB {

	// metodo para conectar com o banco de dados
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = (Connection) DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
		return conn;
	}

	// Implementa��o para fechar uma conex�o
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		// abrindo arquivo e lendo
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}

	}

	// metodo AUXILIARES PARA FECHAR OS OBJETOS st, rs, DB e n�o precisar fazer um
	// try em cada close.
	public static void closeStatament(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}

		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}

		}
	}

}