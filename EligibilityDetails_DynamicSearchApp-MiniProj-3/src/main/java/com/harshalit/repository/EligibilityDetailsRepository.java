package com.harshalit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.harshalit.entity.EligibilityDetails;

@Repository
public interface EligibilityDetailsRepository extends JpaRepository<EligibilityDetails, Serializable>, JpaSpecificationExecutor<EligibilityDetails> {

	
	
}
