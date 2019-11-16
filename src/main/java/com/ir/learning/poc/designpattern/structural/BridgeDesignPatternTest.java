package com.ir.learning.poc.designpattern.structural;

import com.ir.learning.poc.designpattern.core.Assemble;
import com.ir.learning.poc.designpattern.core.Bike;
import com.ir.learning.poc.designpattern.core.Car;
import com.ir.learning.poc.designpattern.core.Produce;
import com.ir.learning.poc.designpattern.core.Vehicle;

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
