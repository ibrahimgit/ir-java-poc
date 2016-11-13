package com.ir.learning.poc.designpattern.bridge;

public class Car extends Vehicle {

	Car(Workshop workshop) {
		super(workshop);
	}

	@Override
	public void manufacture() {
		System.out.println("Car");
		workshop.work();
	}

}
