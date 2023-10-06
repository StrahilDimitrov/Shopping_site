package com.example.shopping.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductsRestController {
	private final ProductService productService;

	public ProductsRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductViewDto>> getAllProducts() {
		List<ProductViewDto> products = this.productService.getAllProducts();

		return ResponseEntity.ok(products);
	}
}
