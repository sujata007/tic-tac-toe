package com.ride.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.driverapi.model.ShippingDetail;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingDetail, Long> {

}
