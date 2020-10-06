package com.ensat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ensat.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findTopByOrderByIdDesc();

}
