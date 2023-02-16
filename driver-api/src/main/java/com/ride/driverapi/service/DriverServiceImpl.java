package com.ride.driverapi.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ride.driverapi.exception.BadRequestException;
import com.ride.driverapi.exception.ElementNotFoundException;
import com.ride.driverapi.model.DocumentType;
import com.ride.driverapi.model.Driver;
import com.ride.driverapi.model.DriverDocRequest;
import com.ride.driverapi.model.DriverDocument;
import com.ride.driverapi.model.SignUpRequest;
import com.ride.driverapi.model.Status;
import com.ride.driverapi.repository.DocumentRepository;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.utils.Constants;
import com.ride.driverapi.utils.FileUploadUtil;
import com.ride.driverapi.utils.Validator;

@Service
public class DriverServiceImpl implements DriverService {
	private final DriverRepository driverRepository;
	private final DocumentRepository documentRepository;

	@Autowired
	DriverServiceImpl(DriverRepository driverRepository, DocumentRepository documentRepository) {
		this.driverRepository = driverRepository;
		this.documentRepository = documentRepository;
	}

	public Driver signUpDriver(SignUpRequest request) {
		// TODO Auto-generated method stub
		boolean isValidEmail = Validator.isEmailValid(request.getEmailId());

		if (!isValidEmail) {
			throw new BadRequestException("Email not valid");
		}
		boolean isValidPhoneNumber = Validator.isValidMobileNo(request.getPhoneNumber());

		if (!isValidPhoneNumber) {
			throw new BadRequestException("Phone Number is not valid");
		}
		Driver driver = new Driver.Builder(request.getEmailId()).setPhoneNumber(request.getPhoneNumber())
				.setFirstName(request.getFirstName()).setLastName(request.getLastName())
				.setPassword(request.getPassword()).setStatus(Status.NEW).build();
		return driverRepository.save(driver);
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
					.filter((doc) -> Constants.DEFAULT_DOCUMENT_TYPE_STRINGS.contains(uploadRequest.getDocumentType()))
					.findFirst();
			FileUploadUtil.saveFile(uploadDir, fileName, file);
			DriverDocument driverDoc = null;
			if (existingDoc.isPresent()) {
				driverDoc = existingDoc.get();
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
		Optional<Driver> driver = driverRepository.findById(driverId);
		if (driver.isPresent()) {
			System.out.print("Getting the status");
			return driver.get().getStatus().toString();
		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
	}

}
