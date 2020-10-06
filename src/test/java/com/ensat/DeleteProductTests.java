package com.ensat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ensat.controllers.ProductController;
import com.ensat.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
public class DeleteProductTests {

	@Autowired
	ProductController productController;

	@Test
	public void delete10Products() {
		final List<Product> productsToDelete = new ArrayList<>();
		productController.listProducts(10).forEach(productsToDelete::add);
		assertThat(productsToDelete).isNotNull();
		assertThat(productsToDelete.size()).isEqualTo(10);
		assertThat(productController.deleteAllProducts(productsToDelete)).isEqualTo("redirect:/products");
	}

	@Test
	public void delete100Products() {
		final List<Product> productsToDelete = new ArrayList<>();
		productController.listProducts(100).forEach(productsToDelete::add);
		assertThat(productsToDelete).isNotNull();
		assertThat(productsToDelete.size()).isEqualTo(100);
		assertThat(productController.deleteAllProducts(productsToDelete)).isEqualTo("redirect:/products");
	}

	@Test
	public void delete1000Products() {
		final List<Product> productsToDelete = new ArrayList<>();
		productController.listProducts(1000).forEach(productsToDelete::add);
		assertThat(productsToDelete).isNotNull();
		assertThat(productsToDelete.size()).isEqualTo(1000);
		assertThat(productController.deleteAllProducts(productsToDelete)).isEqualTo("redirect:/products");
	}

	@Test
	public void delete2000Products() {
		final List<Product> productsToDelete = new ArrayList<>();
		productController.listProducts(2000).forEach(productsToDelete::add);
		assertThat(productsToDelete).isNotNull();
		if (productsToDelete.size() < 2000) {
			productsToDelete.clear();
			productController.listAll().forEach(productsToDelete::add);
		} else {
			assertThat(productsToDelete.size()).isEqualTo(2000);
		}
		assertThat(productController.deleteAllProducts(productsToDelete)).isEqualTo("redirect:/products");
	}

}
