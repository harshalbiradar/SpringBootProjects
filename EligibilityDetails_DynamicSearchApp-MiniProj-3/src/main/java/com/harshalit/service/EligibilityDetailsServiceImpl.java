package com.harshalit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.harshalit.entity.EligibilityDetails;
import com.harshalit.model.EligibilityDetailsModel;
import com.harshalit.repository.EligibilityDetailsRepository;
import com.harshalit.repository.specification.EligibilityDetailsSpecification;



@Service
public class EligibilityDetailsServiceImpl implements EligibilityDetailsService {

	@Autowired
	private EligibilityDetailsRepository repository;

	@Override
	public List<EligibilityDetails> getPlanDetails(EligibilityDetailsModel model) {

		return repository.findAll(Specification.where(EligibilityDetailsSpecification.hasPlanName(model.getPlanName()))
				.and(EligibilityDetailsSpecification.hasPlanStatus(model.getPlanStatus()))
				.and(EligibilityDetailsSpecification.equalsPlanStartDate(model.getPlanStartDate()))
				.and(EligibilityDetailsSpecification.getPlansLessThanOrEqualToForPlanStartDate(model.getPlanStartDate()))
				.and(EligibilityDetailsSpecification.getPlansLessThanOrEqualToForPlanEndDate(model.getPlanEndDate()))
				);
	}
	

	@Override
	public List<EligibilityDetails> getAllEDPlanRecords() {
		return repository.findAll();
	}

	@Override
	public void savePlan(EligibilityDetails details) {
		repository.save(details);
	}



	

}
