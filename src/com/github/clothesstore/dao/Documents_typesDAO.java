package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Documents_types;

public interface Documents_typesDAO extends DAO<Documents_types> {

	void deleteById(Integer id);
	Documents_types findById(Integer id);
	List<Documents_types> findAll();
}
