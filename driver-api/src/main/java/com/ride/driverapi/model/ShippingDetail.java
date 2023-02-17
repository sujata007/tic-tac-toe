package com.ride.driverapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShippingDetail implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipmentID;
	private Long driverId;
	private String deviceId;
	private ShippingStatus status;


}
