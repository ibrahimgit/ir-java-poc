package com.ir.learning.poc.designpattern.bridge;

public abstract class Vehicle {
	
	protected Workshop workshop;
	
	Vehicle(Workshop workshop) {
		this.workshop = workshop;
	}
	
	public abstract void manufacture();

}
