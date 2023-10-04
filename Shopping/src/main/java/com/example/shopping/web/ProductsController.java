package com.example.shopping.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ProductViewDto;
import com.example.shopping.service.InitService;
import com.example.shopping.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	private final ProductService productService;

	public ProductsController(InitService init, ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/search")
	public ModelAndView getSearchResult(String filter, ModelAndView modelAndView) {
		List<ProductViewDto> products = this.productService.search(filter);
		modelAndView.addObject("searchResult", products);
		modelAndView.setViewName("searchPage");

		return modelAndView;
	}

	@GetMapping("/computers")
	public ModelAndView getComputers(ModelAndView modelAndView) {
		List<ProductViewDto> computers = this.productService.getProductsFromCat("Computers");

		modelAndView.addObject("products", computers);
		modelAndView.setViewName("computerPage");

		return modelAndView;
	}
}
