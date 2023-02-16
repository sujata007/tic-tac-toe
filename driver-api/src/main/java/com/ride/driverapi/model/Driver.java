package com.ride.driverapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String emailId;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String password;
	private Vehicle vehicle;
	private Status status;

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

	public String getEmailId() {
		return emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Driver(Builder builder) {
		this.id = builder.id;
		this.emailId = builder.emailId;
		this.phoneNumber = builder.phoneNumber;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.password = builder.password;
		this.vehicle = builder.vehicle;
		this.status = builder.status;

	}

	public static class Builder {
		private Long id;
		private String emailId;
		private String phoneNumber;
		private String firstName;
		private String lastName;
		private String password;
		private Vehicle vehicle;
		private Status status;

		public Builder(String emailId) {
			this.emailId = emailId;
		}
		public Builder setStatus(Status status) {
			this.status = status;
			return this;
		}
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}

		public Driver build() {
			return new Driver(this);
		}

	}
}
