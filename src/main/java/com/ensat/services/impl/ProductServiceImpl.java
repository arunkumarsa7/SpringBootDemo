package com.ensat.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Product;
import com.ensat.repositories.ProductRepository;
import com.ensat.services.ProductService;

/**
 * Product service implement.
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(final Integer id) {
		final Optional<Product> product = productRepository.findById(id);
		return product.isPresent() ? product.get() : new Product();
	}

	@Override
	public Product saveProduct(final Product product) {
		return productRepository.save(product);
	}

	@Override
	public Iterable<Product> saveAllProducts(final List<Product> products) {
		return productRepository.saveAll(products);
	}

	@Override
	public void deleteProduct(final Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product getLatestProduct() {
		return productRepository.findTopByOrderByIdDesc();
	}

	@Override
	public void deleteAllProducts(final List<Product> products) {
		productRepository.deleteAll(products);
	}

	@Override
	public Iterable<Product> listProducts(final Integer count) {
		if (count == 10) {
			return productRepository.findTop10ByOrderByIdDesc();
		}
		if (count == 100) {
			return productRepository.findTop100ByOrderByIdDesc();
		}
		if (count == 1000) {
			return productRepository.findTop1000ByOrderByIdDesc();
		}
		if (count == 2000) {
			return productRepository.findTop2000ByOrderByIdDesc();
		} else {
			return productRepository.findAll();
		}
	}

}
