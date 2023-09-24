package com.example.shopping.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.shopping.model.dto.RegisterFormDto;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void registerUser(RegisterFormDto userRegisterForm) {
		UserEntity user = new UserEntity();
		
		user.setEmail(userRegisterForm.getEmail())
			.setPassword(passwordEncoder.encode(userRegisterForm.getPassword()))
			.setPhoneNumber(userRegisterForm.getPhoneNumber());
		
		this.userRepository.save(user);
	}

}
