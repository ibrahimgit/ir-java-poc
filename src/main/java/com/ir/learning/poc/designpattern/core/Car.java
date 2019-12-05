package com.ir.learning.poc.designpattern.core;

import org.apache.log4j.Logger;

import com.ir.learning.poc.designpattern.Workshop;

public class Car extends Vehicle {
	
	private static final Logger LOGGER = Logger.getLogger(Car.class);

	public Car(Workshop workshop) {
		super(workshop);
	}

	@Override
	public void manufacture() {
		LOGGER.info("Car");
		workshop.work();
	}

}
