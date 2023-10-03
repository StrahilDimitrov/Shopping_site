package com.example.shopping.model.dto;

import java.math.BigDecimal;

import com.example.shopping.model.entity.ProductEntity;

public class ProductViewDto {
	private Long id;

	private String productName;

	private BigDecimal price;

	private String image;

	public ProductViewDto() {

	}

	public ProductViewDto(Long id, String productName, BigDecimal price, String image) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public ProductViewDto setId(Long id) {
		this.id = id;
		return this;
	}

	public String getProductName() {
		return productName;
	}

	public ProductViewDto setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductViewDto setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public String getImage() {
		return image;
	}

	public ProductViewDto setImage(String image) {
		this.image = image;
		return this;
	}

	public static ProductViewDto mapToProductDto(ProductEntity productEntity) {
		ProductViewDto productDto = new ProductViewDto();
		
		productDto.setId(productEntity.getId())
			.setImage(productEntity.getImage())
			.setPrice(productEntity.getPrice())
			.setProductName(productEntity.getProductName());
		
		return productDto;
	}
}
