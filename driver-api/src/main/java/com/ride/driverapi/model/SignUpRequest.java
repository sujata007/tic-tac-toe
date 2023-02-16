package com.ride.driverapi.model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SignUpRequest {
	private String emailId;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String password;
}
