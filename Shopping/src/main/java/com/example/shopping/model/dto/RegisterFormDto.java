package com.example.shopping.model.dto;

public class RegisterFormDto {
	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String phoneNumber;

	public RegisterFormDto() {

	}

	public RegisterFormDto(String firstName, String lastName, String email, String password, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public RegisterFormDto setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public RegisterFormDto setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public RegisterFormDto setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public RegisterFormDto setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public RegisterFormDto setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

}
