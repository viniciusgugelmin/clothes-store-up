package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Genders;

public interface GendersDAO {

	void insert(Genders obj);

	List<Genders> findAll();

	void update(Genders gender);

	void deleteById(Genders gender);

	GendersDAO findById(Genders gender);

	GendersDAO findById(char gender);

	void deleteByGender(Genders gender);

	void deleteByGender(char gender);




}
