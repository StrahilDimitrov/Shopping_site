package com.example.shopping.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.service.ShoppingCartService;

@Controller
public class CategoriesController {
    private final ShoppingCartService shoppingCartService;

    public CategoriesController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/categories")
    public ModelAndView getCategories(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
        this.shoppingCartService.loadShoppingCart(modelAndView, user);

        modelAndView.setViewName("Categories");

        return modelAndView;
    }
}
