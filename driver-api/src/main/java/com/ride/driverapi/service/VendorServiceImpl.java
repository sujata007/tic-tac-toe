package com.ride.driverapi.service;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ride.driverapi.dto.DriverDAO;
import com.ride.driverapi.exception.BadRequestException;
import com.ride.driverapi.exception.ElementNotFoundException;
import com.ride.driverapi.model.DocumentType;
import com.ride.driverapi.model.DriverDocument;
import com.ride.driverapi.model.Status;
import com.ride.driverapi.model.VerificationStatus;
import com.ride.driverapi.repository.DocumentRepository;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.utils.Constants;
import com.ride.driverapi.utils.FileUtil;

@Service
public class VendorServiceImpl implements VendorService {
	private final DriverRepository driverRepository;
	private final DocumentRepository driverDocument;

	@Autowired
	VendorServiceImpl(DriverRepository driverRepository, DocumentRepository driverDocument) {
		this.driverRepository = driverRepository;
		this.driverDocument = driverDocument;
	}

	public void verfiyDriver(Long driverId, String status) {
		// TODO Auto-generated method stub
		Optional<DriverDAO> driver = driverRepository.findById(driverId);
		if (driver.isPresent()) {
			Optional<VerificationStatus> verStatus = VerificationStatus.getVerificationStatus(status);
			if (verStatus.isPresent()) {
				driver.get().setStatus(verStatus.get() == VerificationStatus.VERIFIED ? Status.VERIFICATION_COMPLETED
						: Status.REJECTED);
				driverRepository.save(driver.get());
			} else {
				throw new BadRequestException("Status is not valid");
			}

		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
	}

	@Override
	public Resource downLoadFiles(Long driverId, DocumentType documentType) {
		// TODO Auto-generated method stub

		Optional<DriverDAO> driver = driverRepository.findById(driverId);
		if (!driver.isPresent()) {
			Optional<DriverDocument> existingDoc = driverDocument.findAll().stream()
					.filter((doc) -> doc.getDriverId().equals(driverId))
					.filter((doc) -> Constants.DEFAULT_DOCUMENT_TYPE_STRINGS.contains(documentType.toString()))
					.findFirst();
			if (existingDoc.isPresent()) {
				String fileName = existingDoc.get().getPath();
				try {
					return FileUtil.loadFileAsResource(fileName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				throw new ElementNotFoundException("The file has not been uploaded");
			}

		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
		return null;
	}

}
