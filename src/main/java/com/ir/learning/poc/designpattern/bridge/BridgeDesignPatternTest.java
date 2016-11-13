package com.ir.learning.poc.designpattern.bridge;

public class BridgeDesignPatternTest {

	public static void main(String[] args) {

		Vehicle bikeProduce = new Bike(new Produce());
		Vehicle bikeAssemble = new Bike(new Assemble());
		Vehicle carProduce = new Car(new Produce());
		Vehicle carAssemble = new Car(new Assemble());
		
		bikeProduce.manufacture();
		bikeAssemble.manufacture();
		
		carProduce.manufacture();
		carAssemble.manufacture();
	}

}
