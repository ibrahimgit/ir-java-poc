package com.ir.learning.poc.domainmodel;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private Long id;
	private String name;
	private String gender;
	private LocalDate dob;
	

}
