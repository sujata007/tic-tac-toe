package com.ride.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.driverapi.dto.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String>{

}