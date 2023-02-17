package com.ride.driverapi.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ride.driverapi.dto.DriverDAO;
import com.ride.driverapi.dto.Vehicle;
import com.ride.driverapi.exception.BadRequestException;
import com.ride.driverapi.exception.ElementNotFoundException;
import com.ride.driverapi.exception.InvalidDataException;
import com.ride.driverapi.model.DocumentType;
import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.DriverDocRequest;
import com.ride.driverapi.model.DriverDocument;
import com.ride.driverapi.model.EmailDetails;
import com.ride.driverapi.model.Status;
import com.ride.driverapi.model.VerifyRequest;
import com.ride.driverapi.repository.DocumentRepository;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.repository.VehicleRepository;
import com.ride.driverapi.utils.Constants;
import com.ride.driverapi.utils.FileUtil;
import com.ride.driverapi.utils.Validator;

@Service
public class DriverServiceImpl implements DriverService {
	private final DriverRepository driverRepository;
	private final DocumentRepository documentRepository;
	private HashMap<Long, Integer> codes;
	private Random rand;
	@Autowired
	private EmailService emailService;
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	DriverServiceImpl(DriverRepository driverRepository, DocumentRepository documentRepository) {
		this.driverRepository = driverRepository;
		this.documentRepository = documentRepository;
		this.codes = new HashMap<>();
		this.rand = new Random();
	}

	public Long signUpDriver(Driver request) {
		// TODO Auto-generated method stub
		boolean isValidEmail = Validator.isEmailValid(request.getEmailId());

		if (!isValidEmail) {
			throw new BadRequestException("Email not valid");
		}
		boolean isValidPhoneNumber = Validator.isValidMobileNo(request.getPhoneNumber());

		if (!isValidPhoneNumber) {
			throw new BadRequestException("Phone Number is not valid");
		}
		int secretCode = rand.nextInt(10000);
		
		EmailDetails detail = new EmailDetails(request.getEmailId(), " Use code " + secretCode + " as OTP",
				"Verification");
		emailService.sendSimpleMail(detail);
		DriverDAO driver = new DriverDAO(request.getEmailId(),request.getPhoneNumber(),request.getFirstName(),request.getLastName(),
				request.getPassword(),request.getVehicle()!=null?request.getVehicle().getRegNumber():null,Status.INACTIVE);
		if(request.getVehicle()!=null) {
			vehicleRepository.save(request.getVehicle());
		}
		DriverDAO savedDriver = driverRepository.save(driver);
		codes.put(savedDriver.getId(), secretCode);
		return savedDriver.getId();
		
	}

	@Override
	public String uploadDocument(DriverDocRequest uploadRequest, MultipartFile file) {
		// TODO Auto-generated method stub
		final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		final String documentId = UUID.randomUUID().toString();
		String uploadDir = "user-photos/" + uploadRequest.getDriverId() + "/" + uploadRequest.getDocumentType();
		try {
			Long driverId = uploadRequest.getDriverId();
			Optional<DriverDocument> existingDoc = documentRepository.findAll().stream()
					.filter((doc) -> doc.getDriverId().equals(driverId))
					.filter((doc) -> doc.getDocumentType().toString().equals(uploadRequest.getDocumentType()))
					.findFirst();
			FileUtil.saveFile(uploadDir, fileName, file);
			DriverDocument driverDoc = null;
			if (existingDoc.isPresent()) {	
				driverDoc = existingDoc.get();
				//documentRepository.delete(driverDoc);
				driverDoc.setDocumentId(documentId);
			} else {
				DocumentType t = Arrays.stream(DocumentType.values())
						.filter(e -> e.docType.equals(uploadRequest.getDocumentType())).findFirst()
						.orElseThrow(() -> new IllegalStateException(
								String.format("Unsupported type %s.", uploadRequest.getDocumentType())));
				driverDoc = new DriverDocument(documentId, t, driverId, uploadDir + "" + fileName);
			}

			documentRepository.save(driverDoc);
			return driverDoc.getDocumentId();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documentId;
	}

	@Override
	public String getCuurentStatus(Long driverId) {
		// TODO Auto-generated method stub
		Optional<DriverDAO> driver = driverRepository.findById(driverId);
		if (driver.isPresent()) {
			System.out.print("Getting the status");
			return driver.get().getStatus().toString();
		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
	}

	@Override
	public String verifyAccount(VerifyRequest verifyRequest) {
		// TODO Auto-generated method stub
		int otpInCache = codes.get(verifyRequest.getDriverId());
		if (otpInCache == verifyRequest.getCode()) {
			Optional<DriverDAO> driver = driverRepository.findById(verifyRequest.getDriverId());
			driver.get().setStatus(Status.NEW);
			driverRepository.save(driver.get());
			return "Driver is verified!";
		} else {
			throw new InvalidDataException("Code entered is not valid");
		}
	}

	@Override
	public void updateVehicle(Long driverId,Vehicle request) {
		// TODO Auto-generated method stub
		Optional<DriverDAO> driver = driverRepository.findById(driverId);
		if (driver.isPresent()) {
			driver.get().setRegNumber(request.getRegNumber());
			driverRepository.save(driver.get());
			vehicleRepository.save(request);
		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
	
	}


}
