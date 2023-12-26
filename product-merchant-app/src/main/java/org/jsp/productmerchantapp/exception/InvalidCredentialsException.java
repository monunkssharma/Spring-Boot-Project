package org.jsp.productmerchantapp.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Phone or password or id or email";
	}

}
