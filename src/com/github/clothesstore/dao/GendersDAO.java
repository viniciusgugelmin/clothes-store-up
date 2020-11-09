package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Genders;

public interface GendersDAO extends DAO<Genders>{
	
	void update(Genders obj, char oldGender);
	void deleteByGender(char gender);
	List<Genders> findAll();
}
