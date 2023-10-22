package com.example.shopping.exceptions;

public class AccountIsNotActivatedException extends RuntimeException{
    public AccountIsNotActivatedException(String message) {
        super(message);
    }
}
