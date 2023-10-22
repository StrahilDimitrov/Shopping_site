package com.example.shopping.web;

import com.example.shopping.exceptions.AccountIsNotActivatedException;
import com.example.shopping.model.dto.RegisterFormDto;
import com.example.shopping.model.dto.UserDto;
import com.example.shopping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("/forgotPassword")
    public String forgotPassword(String email, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        UserDto user = this.userService.getUserByEmail(email);

        if (user == null) {
            redirectAttributes.addFlashAttribute("invalidEmail", true);
            modelAndView.setViewName("redirect:/auth/forgotPassword");

            return "redirect:/auth/forgotPassword";
        }
        redirectAttributes.addFlashAttribute("validEmail", true);

        userService.sendConfirmationEmail(user);

        return "redirect:/auth/forgotPassword";
    }

    @GetMapping("/changePassword")
    public ModelAndView changePassword(@RequestParam("token") String token, ModelAndView modelAndView) {
        String userEmail = this.userService.verifyToken(token);

        modelAndView.addObject("email", userEmail);
        modelAndView.setViewName("changePassword");

        return modelAndView;
    }

    @PostMapping("/changePassword")
    public ModelAndView changePassword(String email, String password, String confirmPassword, RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
        if (password.equals(confirmPassword)) {
            this.userService.changePassword(email, password);
            modelAndView.setViewName("redirect:/");

            return modelAndView;
        }
        redirectAttributes.addFlashAttribute("wrongPass", true);
        modelAndView.setViewName("redirect:/auth/changePassword");

        return modelAndView;
    }


    @PostMapping("/login-error")
    public String loginError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bad_credentials", true);
        return "redirect:/";
    }

    @ExceptionHandler(AccountIsNotActivatedException.class)
    public ModelAndView notActivatedAccount(RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
        redirectAttributes.addFlashAttribute("notEnabled", true);
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

    @ModelAttribute(name = "registerForm")
    public RegisterFormDto registerForm() {
        return new RegisterFormDto();
    }
}