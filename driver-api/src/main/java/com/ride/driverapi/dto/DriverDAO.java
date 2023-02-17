package com.ride.driverapi.dto;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ride.driverapi.model.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DriverDAO implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String emailId;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String password;
	private String regNumber;
	private Status status;

	public DriverDAO(String emailId, String phoneNumber, String firstName, String lastName, String password,
			String regNumber, Status status) {
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNumber = regNumber;
		this.status = status;
	}
}
