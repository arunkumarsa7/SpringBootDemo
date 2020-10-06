package com.ensat;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

	@Autowired
	ProductController productController;

	@BeforeClass
	public static void setup() {
		COMMON_VERSION = 0;
		COMMON_PRODUCT_ID = "Test Product ";
		COMMON_NAME = "Test Name ";
		COMMON_PRICE = 0.0f;
	}

	@Test
	public void create10Products() {
		final Product product = productController.getLatestProduct();
		final List<Product> tempProducts = createProducts(10, product.getId());
		final List<Product> createdProducts = new ArrayList<>(tempProducts.size());
		productController.saveAllProducts(tempProducts).forEach(createdProducts::add);
		assertThat(createdProducts).isNotNull();
		assertThat(createdProducts.size()).isEqualTo(10);
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
