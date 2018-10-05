package com.apap.tutorial4.service;

import com.apap.tutorial4.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void deletePilot(String licenseNumber);
	void addPilot(PilotModel pilot);
	void updatePilot(String licenseNumber, PilotModel pilot);
	
	
}
