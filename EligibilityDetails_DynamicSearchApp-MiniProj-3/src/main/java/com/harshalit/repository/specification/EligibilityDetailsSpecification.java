package com.harshalit.repository.specification;

import java.util.Date;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.harshalit.entity.EligibilityDetails;
import com.harshalit.entity.EligibilityDetails_;

@Component
public class EligibilityDetailsSpecification {

	public static Specification<EligibilityDetails> hasPlanName(String planName) {
		return ((root, criteriaQuery, criteriaBuilder) -> {
			if (planName == null) {
				return null;
			}
			return criteriaBuilder.like(root.get(EligibilityDetails_.PLAN_NAME), "%" + planName + "%");
		});
	}

	public static Specification<EligibilityDetails> hasPlanStatus(String planStatus) {
		if (planStatus == null) {
			return null;
		}
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.like(root.get(EligibilityDetails_.PLAN_STATUS), "%" + planStatus + "%");
		});
	}
	
	public static Specification<EligibilityDetails> equalsPlanStartDate(Date planStartDate) {
		if (planStartDate == null) {
			return null;
		}
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(EligibilityDetails_.PLAN_START_DATE), planStartDate);
		});
	}

	public static Specification<EligibilityDetails> equalsPlanEndDate(Date planEndDate) {
		if (planEndDate == null) {
			return null;
		}
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get(EligibilityDetails_.PLAN_END_DATE), planEndDate);
		});
	}
	
	public static Specification<EligibilityDetails> getPlansLessThanOrEqualToForPlanStartDate(Date date) {
		if (date == null) {
			return null;
		}
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.lessThanOrEqualTo(root.get(EligibilityDetails_.PLAN_START_DATE), date);
		});
	}

	public static Specification<EligibilityDetails> getPlansLessThanOrEqualToForPlanEndDate(Date date) {
		if (date == null) {
			return null;
		}
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.lessThanOrEqualTo(root.get(EligibilityDetails_.PLAN_END_DATE), date);
		});
	}
}
