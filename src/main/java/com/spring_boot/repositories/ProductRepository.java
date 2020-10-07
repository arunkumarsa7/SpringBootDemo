package com.spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring_boot.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findTopByOrderByIdDesc();

	Iterable<Product> findTop10ByOrderByIdDesc();

	Iterable<Product> findTop100ByOrderByIdDesc();

	Iterable<Product> findTop1000ByOrderByIdDesc();

	Iterable<Product> findTop2000ByOrderByIdDesc();
}
