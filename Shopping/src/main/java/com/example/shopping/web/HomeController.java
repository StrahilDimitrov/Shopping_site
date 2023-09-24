package com.example.shopping.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.model.dto.ShoppingCartItemDto;
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
		List<ShoppingCartItemDto> cartItems = new ArrayList<>();

		if (user != null) {
			cartItems = shoppingItemService.getAllItemsByUser(user.getUsername());
		}

		BigDecimal total = new BigDecimal(0);
		
		for (ShoppingCartItemDto item : cartItems) {
			total = total.add(item.getAmount());
		}

		modelAndView.addObject("total", total);
		modelAndView.addObject("cartItems", cartItems);
		modelAndView.addObject("products", products);
		modelAndView.setViewName("Shopping");

		return modelAndView;
	}
}
