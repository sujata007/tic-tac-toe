package com.ride.driverapi.service;
import org.springframework.stereotype.Component;
import com.ride.driverapi.dto.Vehicle;
@Component
public interface VehicleService {
	public void updateVehicle(Long driverId, Vehicle request);

	public String updateStatus(Long driverId, String status);

}
