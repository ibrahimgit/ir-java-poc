package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Coffee;

public class CappuccinoCoffee implements Coffee {
	
	private Integer price = 20;

	@Override
	public String getDescription() {
		return "Cappuccino Coffee";
	}

	@Override
	public Integer getCost() {
		return this.price;
	}

}
