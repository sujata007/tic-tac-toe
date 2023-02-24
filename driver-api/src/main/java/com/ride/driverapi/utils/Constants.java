package com.ride.driverapi.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ride.driverapi.model.DocumentType;

public class Constants {
	public static final List<String> DEFAULT_DOCUMENT_TYPE_STRINGS = Stream.of(DocumentType.values())
			.map(DocumentType::name).collect(Collectors.toList());
	public static final String INVALID_EMAIL = "Email not valid";
	public static final String INVALID_PHONE = "Phone Number is not valid";
	public static final String DRIVER_NOT_FOUND = "The Driver id is not found";
	public static final String INCORRECT_PASSWORD = "The password is not correct";
	public static final String INVALID_CODE = "Code entered is not valid";
}
