package com.ride.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.driverapi.model.TrackingDevice;

@Repository
public interface DeviceRepository extends JpaRepository<TrackingDevice, Long> {

}
