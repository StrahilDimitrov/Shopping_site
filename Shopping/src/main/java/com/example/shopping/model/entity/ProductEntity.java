package com.example.shopping.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column
	private BigDecimal price;

	@Column
	private String description;

	@Column
	private int quantity;
	

	public ProductEntity() {

	}

	public Long getId() {
		return id;
	}

	public ProductEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public ProductEntity setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductEntity setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductEntity setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

}