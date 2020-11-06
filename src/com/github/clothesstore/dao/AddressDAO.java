package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.dao.model.DAO;
import com.github.clothesstore.model.Address;

public interface AddressDAO extends DAO<Address> {
	
	void update(Address obj, String mainItem);
	void deleteById(Integer id);
	Address findById(Integer id);
	List<Address> findAll();
}
