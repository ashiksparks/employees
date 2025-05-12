package com.siscon.employees.exception;

public class CustomResourceException extends RuntimeException {
	private static final long serialVersionUID = 4641002397322374977L;

	public CustomResourceException(String message) {
		super(message);
	}
}
