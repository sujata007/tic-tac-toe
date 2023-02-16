package com.ride.driverapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ride.driverapi.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class ThirdPartyVendorController {
	private final VendorService vendorService;

	@Autowired
	public ThirdPartyVendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@PostMapping("/verify/{driverId}/{status}")
	@ResponseStatus(HttpStatus.CREATED)
	public void verifyDriver(@PathVariable Long driverId, @PathVariable String status) {
		vendorService.verfiyDriver(driverId, status);
	}
}
