package com.ride.driverapi.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.DriverDocRequest;
import com.ride.driverapi.model.SignUpRequest;
@Component
public interface DriverService {

	Driver signUpDriver(SignUpRequest signUpRequest);

	String uploadDocument(DriverDocRequest uploadRequest, MultipartFile file);

	String getCuurentStatus(Long driverId);

}
