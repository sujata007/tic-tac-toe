package com.ride.driverapi.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ride.driverapi.model.DocumentType;

public class Constants {
	public static final List<String> DEFAULT_DOCUMENT_TYPE_STRINGS = Stream.of(DocumentType.values())
			.map(DocumentType::name).collect(Collectors.toList());
}
