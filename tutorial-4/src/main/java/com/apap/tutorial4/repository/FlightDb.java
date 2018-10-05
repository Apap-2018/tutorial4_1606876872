package com.apap.tutorial4.repository;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long>{
	FlightModel findByFlightNumber(String flightNumber);
	
}
