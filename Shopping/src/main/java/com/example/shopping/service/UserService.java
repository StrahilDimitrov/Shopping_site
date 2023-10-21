package com.example.shopping.service;

import com.example.shopping.model.dto.RegisterFormDto;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterFormDto userRegisterForm) {
        String email = userRegisterForm.getEmail();

        UserEntity user = new UserEntity(userRegisterForm.getFirstName(), userRegisterForm.getLastName(),
                email, passwordEncoder.encode(userRegisterForm.getPassword()),
                userRegisterForm.getPhoneNumber());

        this.userRepository.save(user);
    }

    public boolean checkEmailExistence(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public void changePassword(String email, String newPassword) {
        UserEntity user = this.userRepository.findByEmail(email).orElseThrow();
        user.setPassword(passwordEncoder.encode(newPassword));

        this.userRepository.save(user);
    }
}
