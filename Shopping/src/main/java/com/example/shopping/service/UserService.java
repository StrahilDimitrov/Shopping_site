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
		int count = this.userRepository.countByEmail(userRegisterForm.getEmail());

		if (count > 0) {
			UserEntity user = new UserEntity(userRegisterForm.getFirstName(), userRegisterForm.getLastName(),
					userRegisterForm.getEmail(), passwordEncoder.encode(userRegisterForm.getPassword()),
					userRegisterForm.getPhoneNumber());

			this.userRepository.save(user);
		}

	}

}
