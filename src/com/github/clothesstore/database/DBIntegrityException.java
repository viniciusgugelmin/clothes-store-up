package com.github.clothesstore.database;

public class DBIntegrityException extends RuntimeException {

	//Custom exception of referential integrity.

	private static final long serialVersionUID = 1L;

	public DBIntegrityException(String msg) {
		super(msg);
	}
}

