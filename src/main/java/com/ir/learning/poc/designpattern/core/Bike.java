package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Workshop;

public class Bike extends Vehicle {

	public Bike(Workshop workshop) {
		super(workshop);
	}

	@Override
	public void manufacture() {
		System.out.println("Bike");
		workshop.work();
	}

}
