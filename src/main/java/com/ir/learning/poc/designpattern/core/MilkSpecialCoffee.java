package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Coffee;

public class MilkSpecialCoffee extends SpecialCoffee {
	
	private Coffee coffee;
	
	public MilkSpecialCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + " with milk";
	}

	@Override
	public Integer getCost() {
		return coffee.getCost() + 1;
	}

}
