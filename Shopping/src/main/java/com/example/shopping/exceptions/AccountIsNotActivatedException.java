package com.example.shopping.exceptions;

public class AccountIsNotActivatedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AccountIsNotActivatedException(String message) {
        super(message);
    }
}
