package com.example.shopping.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

	@Column
	private String image;

	@ManyToOne
	private CategoryEntity category;

	public ProductEntity() {

	}

	public ProductEntity(String productName, BigDecimal price, String description, int quantity, String image,
			CategoryEntity category) {
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.image = image;
		this.category = category;
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

	public String getDescription() {
		return description;
	}

	public ProductEntity setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getImage() {
		return image;
	}

	public ProductEntity setImage(String image) {
		this.image = image;
		return this;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public ProductEntity setCategory(CategoryEntity category) {
		this.category = category;
		return this;
	}

}
