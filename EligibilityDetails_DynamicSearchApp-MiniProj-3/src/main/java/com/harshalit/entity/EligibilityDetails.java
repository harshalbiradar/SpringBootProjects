package com.harshalit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Eligibility_Details")
@Data
public class EligibilityDetails {

	@Id
	@GeneratedValue
	@Column(name = "Ed_ID")
	private Integer edId;
	
	@Column(name = "Case_Number")
	private Integer caseNumber;
	
	@Column(name = "Plan_Name")
	private String planName;
	
	@Column(name = "Plan_Status")
	private String planStatus;
	
	@Column(name = "PlanStart_Date")
	private Date planStartDate;
	
	@Column(name = "PlanEnd_Date")
	private Date planEndDate;
	
	@Column(name = "Benefits_Amount")
	private Double benefitsAmount;
	
	@Column(name = "Denial_Reason")
	private String denialReason;
	
	
}
