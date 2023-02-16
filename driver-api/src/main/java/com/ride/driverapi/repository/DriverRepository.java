package com.ride.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.driverapi.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {}
