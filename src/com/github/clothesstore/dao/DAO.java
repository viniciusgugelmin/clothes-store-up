package com.github.clothesstore.dao;

public interface DAO<T> {
	
	void insert (T obj);
	void update (T obj);
}
