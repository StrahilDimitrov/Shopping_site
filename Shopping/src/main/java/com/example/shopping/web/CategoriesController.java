package com.example.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriesController {
	@GetMapping("/categories")
	public ModelAndView getCategories(ModelAndView modelAndView) {
		modelAndView.setViewName("Categories");
		
		return modelAndView;
	}
}
