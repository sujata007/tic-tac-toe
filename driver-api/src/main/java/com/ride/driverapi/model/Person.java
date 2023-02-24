package com.ride.driverapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
	private Long id;
	@NonNull
	private String emailId;
	@NonNull
	private String phoneNumber;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String password;

	public Person(String emailId, String phoneNumber, String firstName, String lastName, String password) {
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}
