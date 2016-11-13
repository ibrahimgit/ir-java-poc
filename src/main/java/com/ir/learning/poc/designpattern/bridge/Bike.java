package com.ir.learning.poc.designpattern.bridge;

public class Bike extends Vehicle {

	Bike(Workshop workshop) {
		super(workshop);
	}

	@Override
	public void manufacture() {
		System.out.println("Bike");
		workshop.work();
	}

}
