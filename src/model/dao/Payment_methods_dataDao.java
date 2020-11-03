package model.dao;

import java.util.List;

public interface Payment_methods_dataDao {
	
	void insert (Payment_methods_dataDao obj);
	void update (Payment_methods_dataDao obj);
	void deleteById(Integer id);
	 Payment_methods_dataDao findById(Integer id);
	

	List<Payment_methods_dataDao> findAll();

}
