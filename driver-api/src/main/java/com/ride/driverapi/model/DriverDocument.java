package com.ride.driverapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDocument implements Serializable {
	private static final long serialVersionUID = 3252591505029724236L;

	@Id
	private String documentId;
	private DocumentType documentType;
	private Long driverId;
	private String path;

}
