package com.ensat;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ensat.controllers.ProductController;
import com.ensat.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
public class CreateProductTests {

	private static int COMMON_VERSION;

	private static String COMMON_PRODUCT_ID;

	private static String COMMON_NAME;

	private static float COMMON_PRICE;

	private static Integer productId;

	@Autowired
	ProductController productController;

	@BeforeClass
	public static void setup() {
		COMMON_VERSION = 0;
		COMMON_PRODUCT_ID = "Test Product ";
		COMMON_NAME = "Test Name ";
		COMMON_PRICE = 0.0f;
	}

	@Before
	public void configure() {
		final Product product = productController.getLatestProduct();
		if (product == null) {
			productId = 0;
		} else {
			productId = productController.getLatestProduct().getId();
		}
	}

	@Test
	public void create10Products() {
		final List<Product> tempProducts = createProducts(10, productId);
		final List<Product> createdProducts = new ArrayList<>(tempProducts.size());
		productController.saveAllProducts(tempProducts).forEach(createdProducts::add);
		assertThat(createdProducts).isNotNull();
		assertThat(createdProducts.size()).isEqualTo(10);
	}

	@Test
	public void create100Products() {
		final List<Product> tempProducts = createProducts(100, productId);
		final List<Product> createdProducts = new ArrayList<>(tempProducts.size());
		productController.saveAllProducts(tempProducts).forEach(createdProducts::add);
		assertThat(createdProducts).isNotNull();
		assertThat(createdProducts.size()).isEqualTo(100);
	}

	@Test
	public void create1000Products() {
		final List<Product> tempProducts = createProducts(1000, productId);
		final List<Product> createdProducts = new ArrayList<>(tempProducts.size());
		productController.saveAllProducts(tempProducts).forEach(createdProducts::add);
		assertThat(createdProducts).isNotNull();
		assertThat(createdProducts.size()).isEqualTo(1000);
	}

	@Test
	public void create2000Products() {
		final List<Product> tempProducts = createProducts(2000, productId);
		final List<Product> createdProducts = new ArrayList<>(tempProducts.size());
		productController.saveAllProducts(tempProducts).forEach(createdProducts::add);
		assertThat(createdProducts).isNotNull();
		assertThat(createdProducts.size()).isEqualTo(2000);
	}

	private List<Product> createProducts(final int productCount, final int latestProductId) {
		final List<Product> products = new ArrayList<>();
		int tempProductReference = latestProductId;
		for (int i = 0; i < productCount; i++) {
			final Product product = new Product(COMMON_VERSION + tempProductReference,
					COMMON_PRODUCT_ID + tempProductReference, COMMON_NAME + tempProductReference,
					new BigDecimal(COMMON_PRICE + tempProductReference));
			products.add(product);
			tempProductReference++;
		}
		return products;
	}

}
