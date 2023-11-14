package com.example.shopping.web;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.service.OrderService;
import com.example.shopping.service.ShoppingCartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/checkout")
    public ModelAndView placeOrder(@AuthenticationPrincipal ApplicationUserDetails user, ModelAndView modelAndView) {
        this.shoppingCartService.loadShoppingCart(modelAndView, user);
        modelAndView.setViewName("cardInformation");

        return modelAndView;
    }

}
