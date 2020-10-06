package com.ensat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ensat.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findTopByOrderByIdDesc();

	Iterable<Product> findTop10ByOrderByIdDesc();

	Iterable<Product> findTop100ByOrderByIdDesc();

	Iterable<Product> findTop1000ByOrderByIdDesc();

	Iterable<Product> findTop2000ByOrderByIdDesc();
}
