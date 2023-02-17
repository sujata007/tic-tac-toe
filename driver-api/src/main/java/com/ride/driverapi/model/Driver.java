package com.ride.driverapi.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends Person implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Status getStatus() {
		return status;
	}

	public Long getId() {
		return id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
