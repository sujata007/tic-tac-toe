package com.ride.driverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.ride.driverapi.*")
@SpringBootApplication
@EnableScheduling
public class DriverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverApiApplication.class, args);
	}

}
