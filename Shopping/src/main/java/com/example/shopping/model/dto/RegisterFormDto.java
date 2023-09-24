package com.example.shopping.model.dto;

public class RegisterFormDto {
	private String email;
	
	private String password;
	
	private String phoneNumber;

	public RegisterFormDto() {

	}

	public RegisterFormDto(String email, String password, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
