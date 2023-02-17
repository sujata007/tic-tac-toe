package com.ride.driverapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ride.driverapi.model.DocumentType;
import com.ride.driverapi.model.VendorVerificationRequest;
import com.ride.driverapi.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class ThirdPartyVendorController {
	private final VendorService vendorService;

	@Autowired
	public ThirdPartyVendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@PostMapping("/verify/")
	@ResponseStatus(HttpStatus.CREATED)
	public void verifyDriver(@RequestBody VendorVerificationRequest request) {
		vendorService.verfiyDriver(request.getDriverId(), request.getStatus());
	}

	@GetMapping(value = "/downloadFile/{driverId}/{type}", produces = "multipart/form-data")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long driverId, @PathVariable DocumentType type) {
		// Load file as Resource
		Resource resource = vendorService.downLoadFiles(driverId, type);
		return ResponseEntity.ok().contentType(MediaType.MULTIPART_FORM_DATA)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
