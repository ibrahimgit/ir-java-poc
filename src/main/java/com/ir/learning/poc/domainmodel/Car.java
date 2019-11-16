package com.ir.learning.poc.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	
	private String name;
	private Integer registrationNumber;
	private String color;

}
