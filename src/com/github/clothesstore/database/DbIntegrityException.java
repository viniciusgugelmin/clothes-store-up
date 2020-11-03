package com.github.clothesstore.database;

public class DbIntegrityException extends RuntimeException {

	//Custom exception of referential integrity.
	
	//Exce��o personalizada de integridade refer�ncial 


	private static final long serialVersionUID = 1L;

	public DbIntegrityException(String msg) {
		super(msg);
	}
}

