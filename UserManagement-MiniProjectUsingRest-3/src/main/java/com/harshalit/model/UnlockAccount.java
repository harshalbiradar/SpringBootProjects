package com.harshalit.model;

import lombok.Data;

@Data
public class UnlockAccount {

	private String emailId;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	
	
}
