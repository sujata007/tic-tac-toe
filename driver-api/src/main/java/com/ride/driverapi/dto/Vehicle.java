package com.ride.driverapi.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;

	@Id
	private String regNumber;
	private Double lat;
	private Double lon;
	private String type;
	private Boolean isAvailable;
}
