package com.app.repository;

import java.util.List;

import com.app.pojos.Product;

public interface ProductRepository {

	List<Product> findAll();

	int save(Product transientProduct);

	boolean existsById(Integer id);

	void deleteById(Integer id);

	Product findById(Integer empId);

	int update(Product transientProduct);


}
