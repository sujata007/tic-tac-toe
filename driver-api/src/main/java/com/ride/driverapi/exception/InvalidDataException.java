package com.ride.driverapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends RuntimeException {
	private static final long serialVersionUID = -5218143265247846948L;

	public InvalidDataException(String message) {
		super(message);
	}

}
