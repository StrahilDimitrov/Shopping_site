package com.example.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopping.model.dto.DetailedProductViewDto;
import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.model.entity.CategoryEntity;
import com.example.shopping.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	public ProductService(ProductRepository productRepository, CategoryService categoryService) {
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}

	public List<ProductViewDto> getAllProducts() {
		List<ProductViewDto> products = this.productRepository.findAll().stream().map(ProductViewDto::mapToProductDto)
				.collect(Collectors.toList());

		return products;
	}

	public List<ProductViewDto> search(String prod) {
		List<ProductViewDto> products = this.productRepository.search(prod).orElse(null).stream()
				.map(ProductViewDto::mapToProductDto).toList();

		return products;

	}

	public List<ProductViewDto> getProductsFromCatName(String categoryName) {
		CategoryEntity category = this.categoryService.getCategoryByName(categoryName);

		return loadItemsByCategory(category);
	}

	public List<ProductViewDto> getProductsFromCat(CategoryEntity category) {
		return loadItemsByCategory(category);
	}

	@Transactional
	public DetailedProductViewDto getProductById(Long id) {
		DetailedProductViewDto product = this.productRepository.findById(id)
				.map(DetailedProductViewDto::mapToDetailedView).get();
		
		return product;
	}

	private List<ProductViewDto> loadItemsByCategory(CategoryEntity category) {
		List<ProductViewDto> products = this.productRepository.findAllByCategory(category).orElseGet(null).stream()
				.map(ProductViewDto::mapToProductDto).toList();

		return products;
	}

}
