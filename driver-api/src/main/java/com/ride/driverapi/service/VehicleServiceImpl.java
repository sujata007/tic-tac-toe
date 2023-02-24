package com.ride.driverapi.service;

import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.driverapi.dto.DriverDAO;
import com.ride.driverapi.dto.Vehicle;
import com.ride.driverapi.exception.ElementNotFoundException;
import com.ride.driverapi.repository.DriverRepository;
import com.ride.driverapi.repository.VehicleRepository;
@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Override
	public void updateVehicle(Long driverId, Vehicle request) {
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

	@Override
	public String updateStatus(Long driverId, String status) {
		// TODO Auto-generated method stub
		Vehicle vehicle = null;
		String avail = "";
		Boolean finalStatus = false;
		
		JSONObject object = (JSONObject) JSONValue.parse(status);
		avail =  (String) object.get("status");
		Optional<DriverDAO> driver = driverRepository.findById(driverId);
		if (driver.isPresent()) {
			vehicle = vehicleRepository.getById(driver.get().getRegNumber());
			vehicle.setIsAvailable(avail.equals("true")?true:false);
			finalStatus = vehicle.getIsAvailable();
			vehicleRepository.save(vehicle);
		} else {
			throw new ElementNotFoundException("The Driver id is not found");
		}
		return "Vehicle avalilability is set to " + finalStatus;
	}
}
