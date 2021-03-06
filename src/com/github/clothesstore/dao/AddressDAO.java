package com.github.clothesstore.dao;

import java.util.List;

import com.github.clothesstore.model.Address;

public interface AddressDAO extends DAO<Address> {
	
	void update(Address obj, String mainItem, Address oldObj);
	void deleteById(Integer id);
	Address findById(Integer id);
	List<Address> findAll();
}
