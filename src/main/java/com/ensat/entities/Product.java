package com.ensat.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Product entity.
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;

	private String productId;

	private String name;

	private BigDecimal price;

	public Product() {
		super();
	}

	public Product(final Integer version, final String productId, final String name, final BigDecimal price) {
		super();
		this.version = version;
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(final String productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [version=" + version + ", productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}

}
