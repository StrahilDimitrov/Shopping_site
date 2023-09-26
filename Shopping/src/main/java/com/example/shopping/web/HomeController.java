package com.example.shopping.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.service.ProductService;
import com.example.shopping.service.ShoppingItemService;

@Controller
public class HomeController {
	private final ProductService productService;
	private final ShoppingItemService shoppingItemService;

	public HomeController(ProductService productService, ShoppingItemService shoppingItemService) {
		this.productService = productService;
		this.shoppingItemService = shoppingItemService;
	}

	@GetMapping("/")
	public ModelAndView getHome(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		List<ProductViewDto> products = productService.getAllProducts();

		this.shoppingItemService.loadShoppingCart(modelAndView, user);

		modelAndView.addObject("products", products);
		modelAndView.setViewName("Shopping");

		return modelAndView;
	}

	@GetMapping("/aboutUs")
	public ModelAndView getAboutUs(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		this.shoppingItemService.loadShoppingCart(modelAndView, user);
		modelAndView.setViewName("AboutUs");

		return modelAndView;
	}
}
