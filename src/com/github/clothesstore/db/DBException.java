package com.github.clothesstore.db;


public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException (String msg) {
		super(msg);
	}
}
