package com.example.shopping.model.dto;

public class LoginForm {
    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public LoginForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginForm setPassword(String password) {
        this.password = password;
        return this;
    }
}
