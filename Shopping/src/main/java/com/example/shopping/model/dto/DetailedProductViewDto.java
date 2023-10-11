package com.example.shopping.model.dto;

import java.math.BigDecimal;

import com.example.shopping.model.entity.ProductEntity;

public class DetailedProductViewDto {
	private Long id;

	private String productName;

	private BigDecimal price;

	private String image;

	private String specs;

	public DetailedProductViewDto() {

	}

	public DetailedProductViewDto(String productName, BigDecimal price, String image, String specs) {
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.specs = specs;
	}

	public Long getId() {
		return id;
	}

	public DetailedProductViewDto setId(Long id) {
		this.id = id;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public DetailedProductViewDto setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public DetailedProductViewDto setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public String getImage() {
		return image;
	}

	public DetailedProductViewDto setImage(String image) {
		this.image = image;
		return this;
	}

	public String getSpecs() {
		return specs;
	}

	public DetailedProductViewDto setSpecs(String specs) {
		this.specs = specs;
		return this;
	}

	public static DetailedProductViewDto mapToDetailedView(ProductEntity productEntity) {
		DetailedProductViewDto product = new DetailedProductViewDto();

		product.setId(productEntity.getId())
			.setImage(productEntity.getImage())
			.setPrice(productEntity.getPrice())
			.setProductName(productEntity.getProductName()).setSpecs(null);

		return product;
	}

}
