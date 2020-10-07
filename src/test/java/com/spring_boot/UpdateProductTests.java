package com.spring_boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring_boot.SpringBootWebApplication;
import com.spring_boot.controllers.ProductController;
import com.spring_boot.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
public class UpdateProductTests {

	@Autowired
	ProductController productController;

	@Test
	public void update10Products() {
		final List<Product> productsToUpdate = new ArrayList<>();
		final List<Product> updatedProducts = new ArrayList<>();
		productController.listProducts(2000).forEach(productsToUpdate::add);
		assertThat(productsToUpdate).isNotNull();
		assertThat(productsToUpdate.size()).isEqualTo(2000);
		updateProducts(productsToUpdate);
		productController.updateAllProducts(productsToUpdate).forEach(updatedProducts::add);
		assertThat(updatedProducts).isNotNull();
		assertThat(updatedProducts.size()).isEqualTo(2000);
	}

	@Test
	public void update100Products() {
		final List<Product> productsToUpdate = new ArrayList<>();
		final List<Product> updatedProducts = new ArrayList<>();
		productController.listProducts(100).forEach(productsToUpdate::add);
		assertThat(productsToUpdate).isNotNull();
		assertThat(productsToUpdate.size()).isEqualTo(100);
		updateProducts(productsToUpdate);
		productController.updateAllProducts(productsToUpdate).forEach(updatedProducts::add);
		assertThat(updatedProducts).isNotNull();
		assertThat(updatedProducts.size()).isEqualTo(100);
	}

	@Test
	public void update1000Products() {
		final List<Product> productsToUpdate = new ArrayList<>();
		final List<Product> updatedProducts = new ArrayList<>();
		productController.listProducts(1000).forEach(productsToUpdate::add);
		assertThat(productsToUpdate).isNotNull();
		assertThat(productsToUpdate.size()).isEqualTo(1000);
		updateProducts(productsToUpdate);
		productController.updateAllProducts(productsToUpdate).forEach(updatedProducts::add);
		assertThat(updatedProducts).isNotNull();
		assertThat(updatedProducts.size()).isEqualTo(1000);
	}

	@Test
	public void update2000Products() {
		final List<Product> productsToUpdate = new ArrayList<>();
		final List<Product> updatedProducts = new ArrayList<>();
		productController.listProducts(2000).forEach(productsToUpdate::add);
		assertThat(productsToUpdate).isNotNull();
		assertThat(productsToUpdate.size()).isEqualTo(2000);
		updateProducts(productsToUpdate);
		productController.updateAllProducts(productsToUpdate).forEach(updatedProducts::add);
		assertThat(updatedProducts).isNotNull();
		assertThat(updatedProducts.size()).isEqualTo(2000);
	}

	private void updateProducts(final List<Product> productsToUpdate) {
		for (final Product product : productsToUpdate) {
			product.setName(product.getName() + " Updated");
			product.setProductId(product.getProductId() + " Updated");
		}
	}

}
