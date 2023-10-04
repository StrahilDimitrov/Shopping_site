package com.example.shopping.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.service.ShoppingItemService;

@Controller
public class HomeController {
	private final ShoppingItemService shoppingItemService;

	public HomeController(ShoppingItemService shoppingItemService) {
		this.shoppingItemService = shoppingItemService;
	}

	@GetMapping("/")
	public ModelAndView getHome(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		this.shoppingItemService.loadShoppingCart(modelAndView, user);

		modelAndView.setViewName("Shopping");

		return modelAndView;
	}

	@GetMapping("/aboutUs")
	public ModelAndView getAboutUs(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		this.shoppingItemService.loadShoppingCart(modelAndView, user);
		modelAndView.setViewName("AboutUs");

		return modelAndView;
	}
	
	@GetMapping("/reviews")
	public ModelAndView getReviews(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
		this.shoppingItemService.loadShoppingCart(modelAndView, user);
		modelAndView.setViewName("Review");

		return modelAndView;
	}
}
