package com.github.clothesstore.dao.model;

public interface DAO<T> {
	
	void insert (T obj);
	void update (T obj);
}
