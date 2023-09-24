package com.example.shopping.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.service.ProductService;

@Controller
public class HomeController {
	private final ProductService productService;

	public HomeController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/")
	public ModelAndView getHome(ModelAndView modelAndView) {
		List<ProductViewDto> products = productService.getAllProducts();
		
		modelAndView.addObject("products", products);
		modelAndView.setViewName("Shopping");
		
		return modelAndView;
	}
}
