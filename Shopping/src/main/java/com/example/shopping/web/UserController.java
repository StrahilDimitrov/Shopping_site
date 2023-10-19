package com.example.shopping.web;

import com.example.shopping.model.dto.ApplicationUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/profile")
    public ModelAndView getProfilePage(ModelAndView modelAndView, @AuthenticationPrincipal ApplicationUserDetails user) {
        modelAndView.addObject("email", user.getUsername())
                .addObject("fullName", user.getFullName())
                .setViewName("profilePage");

        return modelAndView;
    }
}
