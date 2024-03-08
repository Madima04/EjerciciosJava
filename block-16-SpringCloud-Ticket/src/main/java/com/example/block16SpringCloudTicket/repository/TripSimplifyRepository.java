package com.example.block16SpringCloudTicket.repository;

import com.example.block16SpringCloudTicket.domain.TripSimplify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripSimplifyRepository extends JpaRepository<TripSimplify, Integer> {
    @Query("SELECT t FROM TripSimplify t WHERE t.tripId = ?1")
    TripSimplify findByTripId(int tripId);
}
