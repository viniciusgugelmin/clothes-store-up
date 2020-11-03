package dbConnection;

public class DbIntegrityException extends RuntimeException {

	

	//Custom exception of referential integrity.

	//Exceção personalizada de integridade referêncial 


		private static final long serialVersionUID = 1L;

		public DbIntegrityException(String msg) {
			super(msg);

		}
	}


