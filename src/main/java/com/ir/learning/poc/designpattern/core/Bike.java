package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Workshop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bike extends Vehicle {

	public Bike(Workshop workshop) {
		super(workshop);
	}

	@Override
	public void manufacture() {
		log.info("Bike");
		workshop.work();
	}

}
