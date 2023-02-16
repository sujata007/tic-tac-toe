package com.ride.driverapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String regNumber;
	private Double lat;
	private Double lon;
	private String type;
	private Boolean isAvailable;
	private String driverId;
}
