package com.example.shopping.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.model.dto.ShoppingCartDto;
import com.example.shopping.service.ProductService;
import com.example.shopping.service.ShoppingItemService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductsRestController {
	private final ProductService productService;
	private final ShoppingItemService shoppingItemService;

	public ProductsRestController(ProductService productService, ShoppingItemService shoppingItemService) {
		this.productService = productService;
		this.shoppingItemService = shoppingItemService;
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductViewDto>> getAllProducts() {
		List<ProductViewDto> products = this.productService.getAllProducts();

		return ResponseEntity.ok(products);
	}

	@GetMapping("/computers")
	public ResponseEntity<Object> getComputers(@AuthenticationPrincipal ApplicationUserDetails user) {
		List<ProductViewDto> computers = this.productService.getProductsFromCat("Computers");
		ShoppingCartDto shoppingCart = this.shoppingItemService.getShoppingCart(user);

		return ResponseEntity.ok(List.of(shoppingCart, computers));
	}

	@GetMapping("/smartphones")
	public ResponseEntity<Object> getPhones(@AuthenticationPrincipal ApplicationUserDetails user) {
		List<ProductViewDto> phones = this.productService.getProductsFromCat("smartphones");
		ShoppingCartDto shoppingCart = this.shoppingItemService.getShoppingCart(user);

		return ResponseEntity.ok(List.of(shoppingCart, phones));
	}
}
