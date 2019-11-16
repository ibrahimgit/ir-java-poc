package com.ir.learning.poc.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Applicant {
	
	private String fullName;
	private String sex;
	private String city;
	private String martialStatus;
	
	

}
