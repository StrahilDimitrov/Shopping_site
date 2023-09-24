package com.example.shopping.model.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ApplicationUserDetails extends User {
	private static final long serialVersionUID = 1L;
	private String phoneNumber;

	public ApplicationUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities,
			String phoneNumber) {
		super(email, password, authorities);
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public ApplicationUserDetails setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
}
