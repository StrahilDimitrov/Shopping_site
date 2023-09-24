package com.example.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<ProductViewDto> getAllProducts() {
		List<ProductViewDto> products = this.productRepository.findAll()
				.stream()
				.map(ProductViewDto::mapToProductDto)
				.collect(Collectors.toList());
		
		return products;
	}

}
