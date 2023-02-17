package com.ride.driverapi.service;

import org.springframework.core.io.Resource;

import com.ride.driverapi.model.DocumentType;

public interface VendorService {

	void verfiyDriver(Long driverId, String status);

	Resource downLoadFiles(Long driverId, DocumentType type);

}
