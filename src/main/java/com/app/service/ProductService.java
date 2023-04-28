package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface ProductService {
	List<Product> getAllProducts();

	int add(Product transientProduct);

	String delete(Integer id);

	Product fetchById(Integer id);

	int update(Product detachedProduct);


}
