package com.ride.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.driverapi.model.DriverDocument;
@Repository
public interface DocumentRepository extends JpaRepository<DriverDocument, Long> {
}
