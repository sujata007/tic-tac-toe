package com.ride.driverapi.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.DriverDocRequest;
import com.ride.driverapi.model.VerifyRequest;

@Component
public interface DriverService {

	Long signUpDriver(Driver signUpRequest);

	String uploadDocument(DriverDocRequest uploadRequest, MultipartFile file);

	String getCuurentStatus(Long driverId);

	String verifyAccount(VerifyRequest verifyRequest);

	Long loginDriver(String logInRequest);

}
