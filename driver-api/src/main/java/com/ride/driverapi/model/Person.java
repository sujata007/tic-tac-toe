package com.ride.driverapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
	private Long id;
	private String emailId;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String password;

	public Person(String emailId, String phoneNumber, String firstName, String lastName, String password) {
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}
