package com.ride.driverapi.schedulers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.DriverDocument;
import com.ride.driverapi.model.EmailDetails;
import com.ride.driverapi.model.Status;
import com.ride.driverapi.repository.DocumentRepository;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.service.EmailService;

@Component
public class BackGroundVerificationScheduler {
	private static final Logger log = LoggerFactory.getLogger(BackGroundVerificationScheduler.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private DocumentRepository driverDocuemnt;
	@Autowired
	private EmailService emailService;

	@Scheduled(fixedRate = 20000)
	public void reportCurrentTime() {
		System.out.println("Starting BV Worker");
		List<Driver> onboardedDrivers = driverRepository.findAll().stream()
				.filter((driver) -> driver.getStatus() == Status.NEW).collect(Collectors.toList());
		
		for(Driver driver: onboardedDrivers) {
			List<DriverDocument> driversDoc = driverDocuemnt.findAll().stream().filter((driverdoc)->driverdoc.getDriverId().equals(driver.getId())).collect(Collectors.toList());
			System.out.println("Size is " + driversDoc.size());
			if(driversDoc.size()==4) {
				EmailDetails detail = new EmailDetails("priyadarshinee11@gmail.com","Initiate bg verification for driver "+driver.getEmailId(),"BV process");
				emailService.sendSimpleMail(detail);
				driver.setStatus(Status.VERIFICATION_STARTED);
				driverRepository.save(driver);
			}
		}

	}
}
