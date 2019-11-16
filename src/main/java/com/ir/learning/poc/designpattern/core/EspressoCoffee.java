package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Coffee;

public class EspressoCoffee implements Coffee {
	
	private Integer price = 10;

	@Override
	public String getDescription() {
		return "Espresso coffee";
	}

	@Override
	public Integer getCost() {
		return price;
	}

}
