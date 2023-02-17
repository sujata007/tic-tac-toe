package com.ride.driverapi.controller;

import java.io.IOException;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ride.driverapi.exception.FormattedErrorException;
import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.DriverDocRequest;
import com.ride.driverapi.model.SignUpRequest;
import com.ride.driverapi.model.Vehicle;
import com.ride.driverapi.model.VerifyRequest;
import com.ride.driverapi.service.DriverService;
import com.ride.driverapi.utils.Constants;

@RestController
@RequestMapping("/driver")
public class DriverController {
	private final DriverService driverService;

	@Autowired
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public Driver createDriver(@RequestBody SignUpRequest signUpRequest) {
		return driverService.signUpDriver(signUpRequest);
	}

	@GetMapping("/status/{driverId}")
	@ResponseStatus(HttpStatus.OK)
	public String getDriverStatus(@PathVariable Long driverId) {
		return driverService.getCuurentStatus(driverId);
	}

	@PostMapping("/verify")
	@ResponseStatus(HttpStatus.CREATED)
	public Driver verifyAccount(@RequestBody VerifyRequest verifyRequest) {
		return driverService.verifyAccount(verifyRequest);
	}

	@PostMapping(value = "/uploadDocument", consumes = "multipart/form-data")
	@ResponseStatus(HttpStatus.CREATED)
	public String uploadDocument(@RequestPart("driverDetails") String driverDetails,
			@RequestPart("file") MultipartFile file) {
		ObjectMapper objectMapper = new ObjectMapper();
		DriverDocRequest uploadReq = null;
		try {
			uploadReq = objectMapper.readValue(driverDetails, DriverDocRequest.class);
			System.out.println("Now Driver = " + uploadReq);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!Constants.DEFAULT_DOCUMENT_TYPE_STRINGS.contains(uploadReq.getDocumentType())) {
			throw new FormattedErrorException(
					"\"type\" is not one of " + StringUtils.join(Constants.DEFAULT_DOCUMENT_TYPE_STRINGS));
		}
		return driverService.uploadDocument(uploadReq, file);
	}
	@PostMapping("/{driverId}/vehicle")
	@ResponseStatus(HttpStatus.CREATED)
	public void vehicleDetails(@PathVariable Long driverId,@RequestBody Vehicle verifyRequest) {
		 driverService.updateVehicle(driverId,verifyRequest);
	}


}
