package com.example.shopping.validation;

import com.example.shopping.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistingUserValidator implements ConstraintValidator<ValidateUniqueEmail, String> {
    private final UserRepository userRepository;

    @Autowired
    public ExistingUserValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !this.userRepository.existsByEmail(email);
    }
}
