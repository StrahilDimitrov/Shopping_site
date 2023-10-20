package com.example.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.shopping.model.dto.RegisterFormDto;
import com.example.shopping.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String getRegister() {
		return "Register";
	}

	@PostMapping("/register")
	public String register(@Validated RegisterFormDto registerForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("registerForm", registerForm)
					.addFlashAttribute(BINDING_RESULT_PATH + "registerForm", bindingResult);

			return "redirect:/auth/register";
		}
		
		this.userService.registerUser(registerForm);

		return "redirect:/";
	}

	@PostMapping("/login-error")
	public String loginError(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("bad_credentials", true);
		return "redirect:/";
	}

	@ModelAttribute(name = "registerForm")
	public RegisterFormDto registerForm() {
		return new RegisterFormDto();
	}
}