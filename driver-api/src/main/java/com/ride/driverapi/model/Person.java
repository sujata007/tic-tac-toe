package com.ride.driverapi.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Person {
	private String emailId;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String password;
}
