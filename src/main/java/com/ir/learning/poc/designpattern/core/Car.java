package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Workshop;

public class Car extends Vehicle {

	public Car(Workshop workshop) {
		super(workshop);
	}

	@Override
	public void manufacture() {
		System.out.println("Car");
		workshop.work();
	}

}
