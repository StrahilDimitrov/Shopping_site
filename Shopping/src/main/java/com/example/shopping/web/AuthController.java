package com.example.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopping.model.dto.RegisterFormDto;
import com.example.shopping.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String getRegister() {
		return "Register";
	}

	@PostMapping("/register")
	public String register(RegisterFormDto registerForm) {
		this.userService.registerUser(registerForm);
		
		return "Shopping";
	}

	@PostMapping("/login-error")
	public String loginError() {
		return "Shopping";
	}
}