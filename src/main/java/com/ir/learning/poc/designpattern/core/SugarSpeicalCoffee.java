package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Coffee;

public class SugarSpeicalCoffee extends SpecialCoffee {
	
	private Coffee coffee;
	
	public SugarSpeicalCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + " with sugar";
	}

	@Override
	public Integer getCost() {
		return coffee.getCost() + 2;
	}

}
