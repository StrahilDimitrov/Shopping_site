package com.example.shopping.service;

import com.example.shopping.model.dto.UserDto;
import com.example.shopping.model.dto.RegisterFormDto;
import com.example.shopping.model.entity.ConfirmationEntity;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.ConfirmationRepository;
import com.example.shopping.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationRepository confirmationRepository;

    private final EmailService emailService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ConfirmationRepository confirmationRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.confirmationRepository = confirmationRepository;
        this.emailService = emailService;
    }

    public void registerUser(RegisterFormDto userRegisterForm) {
        String email = userRegisterForm.getEmail();

        UserEntity user = new UserEntity(userRegisterForm.getFirstName(), userRegisterForm.getLastName(),
                email, passwordEncoder.encode(userRegisterForm.getPassword()),
                userRegisterForm.getPhoneNumber());

        this.userRepository.save(user);


    }

    public UserDto getUserByEmail(String email) {
        UserEntity userEntity = this.userRepository.findByEmail(email).orElse(null);

        if (userEntity != null) {
            return UserDto.mapToUserDto(userEntity);
        }

        return null;
    }

    public String verifyToken(String token) {
        ConfirmationEntity confirmation = this.confirmationRepository.findByToken(token);
        return confirmation.getUser().getEmail();
    }

    public void changePassword(String email, String newPassword) {
        UserEntity user = this.userRepository.findByEmail(email).orElseThrow();
        user.setPassword(passwordEncoder.encode(newPassword));

        this.userRepository.save(user);
    }

    public void sendConfirmationEmail(UserDto user) {
        UserEntity userEntity = this.userRepository.findByEmail(user.getEmail()).orElse(null);

        ConfirmationEntity confirmation = new ConfirmationEntity(userEntity);
        this.confirmationRepository.save(confirmation);

        this.emailService.sendConfirmationEmail(user.getFirstName(), user.getEmail(), confirmation.getToken());
    }
}
