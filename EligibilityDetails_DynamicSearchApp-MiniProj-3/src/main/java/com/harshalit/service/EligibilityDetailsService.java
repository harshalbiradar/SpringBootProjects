package com.harshalit.service;

import java.util.List;

import com.harshalit.entity.EligibilityDetails;
import com.harshalit.model.EligibilityDetailsModel;

public interface EligibilityDetailsService {


	public List<EligibilityDetails> getPlanDetails(EligibilityDetailsModel model);

	public List<EligibilityDetails> getAllEDPlanRecords();

	public void savePlan(EligibilityDetails details);

	
	
}
