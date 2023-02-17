package com.ride.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.driverapi.dto.DriverDAO;

@Repository
public interface DriverRepository extends JpaRepository<DriverDAO, Long> {}
