package com.ride.driverapi.model;

import com.ride.driverapi.dto.Vehicle;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Driver extends Person {
	private Vehicle vehicle;
	private Status status;
	public Driver(String emailId, String phoneNumber, String firstName, String lastName, String password,
			Vehicle vehicle, Status status) {
		super(emailId, phoneNumber, firstName, lastName, password);
		this.vehicle = vehicle;
		this.status = status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
