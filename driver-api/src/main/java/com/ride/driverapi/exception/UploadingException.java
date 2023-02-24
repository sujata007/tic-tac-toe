package com.ride.driverapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UploadingException extends RuntimeException {
	private static final long serialVersionUID = 6171978443681353425L;

	  public UploadingException(String message) {
	    super(message);
	  }
}
