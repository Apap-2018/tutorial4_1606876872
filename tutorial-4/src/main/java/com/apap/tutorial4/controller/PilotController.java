package com.apap.tutorial4.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.PilotService;

@Controller
public class PilotController {

	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view/{licenseNumber}", method = RequestMethod.GET)
	private String viewPilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilots = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if (pilots==null) {
			model.addAttribute("licenseNum", licenseNumber);
			return "salah";
		}else {
			model.addAttribute("pilot", pilots);
			model.addAttribute("flightList", pilots.getPilotFlight());
			return "view-pilot";
		}	
	}
	
	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		pilotService.deletePilot(licenseNumber);
		return "delete-pilot";
		
	}
	
	@RequestMapping(value = "/pilot/update{licenseNumber}", method = RequestMethod.GET)
	private String update(@PathVariable(value= "licenseNumber") String licenseNumber, Model model) {
		PilotModel oldPilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("oldPilot", oldPilot);
		model.addAttribute("newPilot", new PilotModel());
		return "update-pilot";
	}
	
	@RequestMapping(value = "/pilot/update{licenseNumber}", method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel newPilot, @PathVariable(value = "licenseNumber") String licenseNumber) {
		pilotService.updatePilot(licenseNumber, newPilot);
		return "update";
	}
	
}
 