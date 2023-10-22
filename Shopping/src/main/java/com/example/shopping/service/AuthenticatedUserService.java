package com.example.shopping.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.shopping.model.dto.ApplicationUserDetails;
import com.example.shopping.model.entity.UserEntity;
import com.example.shopping.repository.UserRepository;

public class AuthenticatedUserService implements UserDetailsService {
	private final UserRepository userRepository;

	public AuthenticatedUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + " doesn't exist!"));

		ApplicationUserDetails user = new ApplicationUserDetails(email, userEntity.getPassword(),
				List.of(new SimpleGrantedAuthority("ROLE_")), userEntity.getPhoneNumber(),
				userEntity.getFirstName() + " " + userEntity.getLastName());

		return user;
	}

}
