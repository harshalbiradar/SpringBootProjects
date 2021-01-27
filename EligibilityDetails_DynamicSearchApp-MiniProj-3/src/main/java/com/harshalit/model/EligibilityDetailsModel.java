package com.harshalit.model;

import java.util.Date;

import lombok.Data;


@Data
public class EligibilityDetailsModel {

	private String planName;
	private String planStatus;
	private Date planStartDate;
	private Date planEndDate;


}
