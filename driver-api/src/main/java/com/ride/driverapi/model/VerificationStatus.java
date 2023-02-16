package com.ride.driverapi.model;

import java.util.Optional;

public enum VerificationStatus {
	VERIFIED("accept"), REJECTED("reject");
	public final String status;
	VerificationStatus(String status){
		this.status = status;
	}
	public static Optional<VerificationStatus> getVerificationStatus(String status){
		for(VerificationStatus entry : VerificationStatus.values()) {
			if(entry.status.equalsIgnoreCase(status)) {
				return Optional.of(entry);
			}
		}
		return Optional.empty();
	}
}
