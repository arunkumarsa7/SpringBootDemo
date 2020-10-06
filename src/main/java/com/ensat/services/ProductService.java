package com.ensat.services;

import java.util.List;

import com.ensat.entities.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();

	Product getProductById(Integer id);

	Product saveProduct(Product product);

	void deleteProduct(Integer id);

	Product getLatestProduct();

	Iterable<Product> saveAllProducts(List<Product> products);

	void deleteAllProducts(List<Product> products);

	Iterable<Product> listProducts(Integer count);

}
