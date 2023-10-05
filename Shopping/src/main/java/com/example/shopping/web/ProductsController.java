package com.example.shopping.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.service.InitService;
import com.example.shopping.service.ProductService;
import com.example.shopping.service.ShoppingItemService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	private final ProductService productService;
	private final ShoppingItemService shoppingItemService;

	public ProductsController(InitService init, ProductService productService,
			ShoppingItemService shoppingItemService) {
		this.productService = productService;
		this.shoppingItemService = shoppingItemService;
	}

	@GetMapping("/search")
	public ModelAndView getSearchResult(String filter, ModelAndView modelAndView,
			@AuthenticationPrincipal ApplicationUserDetails user) {
		List<ProductViewDto> products = this.productService.search(filter);
		
		addingToView(modelAndView, products);
		
		this.shoppingItemService.loadShoppingCart(modelAndView, user);

		return modelAndView;
	}

	@GetMapping("/computers")
	public ModelAndView getComputers(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		List<ProductViewDto> computers = this.productService.getProductsFromCat("Computers");

		this.shoppingItemService.loadShoppingCart(modelAndView, user);

		addingToView(modelAndView, computers);

		return modelAndView;
	}

	@GetMapping("/phones")
	public ModelAndView getPhones(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		List<ProductViewDto> phones = this.productService.getProductsFromCat("smartphones");

		this.shoppingItemService.loadShoppingCart(modelAndView, user);

		addingToView(modelAndView, phones);

		return modelAndView;
	}

	private void addingToView(ModelAndView modelAndView, List<ProductViewDto> products) {
		modelAndView.addObject("products", products);
		modelAndView.setViewName("productPage");
	}
}
