/**
 * 
 */
package com.apap.tutorial4.repository;

import com.apap.tutorial4.model.PilotModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author ASUS
 *
 */

@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long>{
	PilotModel findByLicenseNumber(String licenseNumber);

}
