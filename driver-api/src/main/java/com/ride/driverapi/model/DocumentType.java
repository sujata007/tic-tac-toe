package com.ride.driverapi.model;

public enum DocumentType {
	PAN_CARD("PAN_CARD"), PROFILE_PHOTO("PROFILE_PHOTO"), REGISTRATION_CERTIFICATE("REGISTRATION_CERTIFICATE"), VEHICLE_PERMIT("VEHICLE_PERMIT");
	public String docType;

    private DocumentType(String docType) {
        this.docType = docType;
    }
}
