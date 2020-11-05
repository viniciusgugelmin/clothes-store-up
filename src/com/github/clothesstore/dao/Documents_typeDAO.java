package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Documents_type;

public interface Documents_typeDAO extends DAO<Documents_type> {

	void deleteById(Integer id);
	Documents_type findById(Integer id);
	List<Documents_type> findAll();
}
