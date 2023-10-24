package com.example.shopping.web;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.service.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String placeOrder(@AuthenticationPrincipal ApplicationUserDetails user) {
        orderService.placeOrder(user.getUsername());

        return "redirect:/";
    }

}
