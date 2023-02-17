package com.ride.driverapi.schedulers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Shutdown;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ride.driverapi.dto.DriverDAO;
import com.ride.driverapi.model.DeviceStatus;
import com.ride.driverapi.model.DriverDocument;
import com.ride.driverapi.model.EmailDetails;
import com.ride.driverapi.model.ShippingDetail;
import com.ride.driverapi.model.ShippingStatus;
import com.ride.driverapi.model.Status;
import com.ride.driverapi.model.TrackingDevice;
import com.ride.driverapi.repository.DeviceRepository;
import com.ride.driverapi.repository.DocumentRepository;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.repository.ShippingRepository;
import com.ride.driverapi.service.EmailService;

@Component
public class BackGroundWorkerScheduler {
	private static final Logger log = LoggerFactory.getLogger(BackGroundWorkerScheduler.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private DocumentRepository driverDocuemnt;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ShippingRepository shippingRepository;
	@Autowired
	private DeviceRepository deviceRepository;

	@Scheduled(fixedRate = 20000)
	public void triggerBackGrounVerificationProcess() {
		System.out.println("Starting BV Worker");
		List<DriverDAO> onboardedDrivers = driverRepository.findAll().stream()
				.filter((driver) -> driver.getStatus() == Status.NEW).collect(Collectors.toList());
		
		for(DriverDAO driver: onboardedDrivers) {
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
	@Scheduled(fixedRate = 20000)
	public void triggerShippmentOfDevice() {
		System.out.println("Starting Shipment Worker");
		List<DriverDAO> onboardedDrivers = driverRepository.findAll().stream()
				.filter((driver) -> driver.getStatus() == Status.VERIFICATION_COMPLETED).collect(Collectors.toList());
		
		for(DriverDAO driver: onboardedDrivers) {
			String deviceId = UUID.randomUUID().toString();
			TrackingDevice device = new TrackingDevice(deviceId,driver.getId(),DeviceStatus.INACTIVE);
			deviceRepository.save(device);
			ShippingDetail shippingDet = new ShippingDetail();
			shippingDet.setDeviceId(deviceId);
			shippingDet.setDriverId(driver.getId());
			shippingDet.setStatus(ShippingStatus.SHIPPED);
			shippingRepository.save(shippingDet);
			EmailDetails detail = new EmailDetails(driver.getEmailId(),"Your tracking device is getting shipped ","Shipment Details");
			emailService.sendSimpleMail(detail);
			driver.setStatus(Status.ONBOARDED);
		}

	}
}
