package com.example.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopping.model.dto.RegisterFormDto;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/register")
	public String getRegister() {
		return "Register";
	}

	@PostMapping("/register")
	public String register(RegisterFormDto registerForm) {
		return "Shopping";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
}