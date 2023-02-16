package com.ride.driverapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.driverapi.exception.BadRequestException;
import com.ride.driverapi.exception.ElementNotFoundException;
import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.Status;
import com.ride.driverapi.model.VerificationStatus;
import com.ride.driverapi.repository.DriverRepository;
@Service
public class VendorServiceImpl implements VendorService {
	private final DriverRepository driverRepository;

	@Autowired
	VendorServiceImpl(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	public void verfiyDriver(Long driverId, String status) {
		// TODO Auto-generated method stub
		Optional<Driver> driver = driverRepository.findById(driverId);
		if (!driver.isPresent()) {
			Optional<VerificationStatus> verStatus = VerificationStatus.getVerificationStatus(status);
			if(verStatus.isPresent()) {
				driver.get().setStatus(verStatus.get()==VerificationStatus.VERIFIED?Status.VERIFICATION_COMPLETED:Status.REJECTED);
				driverRepository.save(driver.get());
			}else {
				throw new BadRequestException("Status is not valid");
			}
			
		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
	}

}
