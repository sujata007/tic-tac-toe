package com.ride.driverapi.service;

import com.ride.driverapi.model.EmailDetails;

public interface EmailService {
	String sendSimpleMail(EmailDetails details);

}
