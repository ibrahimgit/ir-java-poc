package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Workshop;

public abstract class Vehicle {
	
	protected Workshop workshop;
	
	Vehicle(Workshop workshop) {
		this.workshop = workshop;
	}
	
	public abstract void manufacture();

}
