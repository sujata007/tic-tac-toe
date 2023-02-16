package com.ride.driverapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private DocumentType documentType;
	private Long driverId;
	private String path;
	private String documentId;

	public DriverDocument(String documentId, DocumentType documentType, Long driverTd, String path) {
		this.documentType = documentType;
		this.driverId = driverTd;
		this.path = path;
		this.documentId = documentId;
	}
}
