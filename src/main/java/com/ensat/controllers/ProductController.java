package com.ensat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;

/**
 * Product controller.
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * List all products.
	 *
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/products")
	public String list(final Model model) {
		model.addAttribute("products", productService.listAllProducts());
		System.out.println("Returning rpoducts:");
		return "products";
	}

	/**
	 * View a specific product by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("product/{id}")
	public String showProduct(@PathVariable final Integer id, final Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productshow";
	}

	// Afficher le formulaire de modification du Product
	@GetMapping("product/edit/{id}")
	public String edit(@PathVariable final Integer id, final Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}

	/**
	 * New product.
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("product/new")
	public String newProduct(final Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	/**
	 * Save product to database.
	 *
	 * @param product
	 * @return
	 */
	@PostMapping(path = "product")
	public String saveProduct(final Product product) {
		productService.saveProduct(product);
		return "redirect:/product/" + product.getId();
	}

	/**
	 * Delete product by its id.
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("product/delete/{id}")
	public String delete(@PathVariable final Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}

	/**
	 * Delete product by its id.
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("product/latestProduct")
	public Product getLatestProduct() {
		return productService.getLatestProduct();
	}

	/**
	 * Save products to database.
	 *
	 * @param product
	 * @return
	 */
	@PostMapping(path = "products")
	public Iterable<Product> saveAllProducts(final List<Product> products) {
		return productService.saveAllProducts(products);
	}

}
