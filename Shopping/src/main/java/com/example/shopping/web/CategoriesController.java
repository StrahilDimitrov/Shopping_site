package com.example.shopping.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.service.ShoppingItemService;

@Controller
public class CategoriesController {
	private final ShoppingItemService shoppingItemService;

	public CategoriesController(ShoppingItemService shoppingItemService) {
		this.shoppingItemService = shoppingItemService;
	}

	@GetMapping("/categories")
	public ModelAndView getCategories(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		this.shoppingItemService.loadShoppingCart(modelAndView, user);

		modelAndView.setViewName("Categories");

		return modelAndView;
	}
}
