package com.harshalit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshalit.entity.EligibilityDetails;
import com.harshalit.model.EligibilityDetailsModel;
import com.harshalit.service.EligibilityDetailsService;

@RestController
@RequestMapping("/ed")
public class EligibilityDetailsController {

	@Autowired
	private EligibilityDetailsService service;
	
	
	@PostMapping("/saveplan")
    public void savePlan(@RequestBody EligibilityDetails details) {
        service.savePlan(details);
    }
	
	@PostMapping("/getallplans")
    public List<EligibilityDetails> getAllEDRecords() {
        return service.getAllEDPlanRecords();
    }
	
	@PostMapping("/getplansbyfilter")
	public List<EligibilityDetails> getEligibilityDetailsList(@RequestBody EligibilityDetailsModel model) {
		return service.getPlanDetails(model);
	}

	
}
