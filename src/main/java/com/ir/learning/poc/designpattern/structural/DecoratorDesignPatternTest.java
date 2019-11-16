package com.ir.learning.poc.designpattern.structural;

import com.ir.learning.poc.designpattern.Coffee;
import com.ir.learning.poc.designpattern.core.CappuccinoCoffee;
import com.ir.learning.poc.designpattern.core.EspressoCoffee;
import com.ir.learning.poc.designpattern.core.MilkSpecialCoffee;
import com.ir.learning.poc.designpattern.core.SugarSpeicalCoffee;

public class DecoratorDesignPatternTest {

	public static void main(String[] args) {
		
		// Attach additional responsibilities to an object dynamically. 
		// Decorators provide a flexible alternative to subclassing for extending functionality.
		
		Coffee cappuccinoCoffee = new CappuccinoCoffee();
		//https://www.geeksforgeeks.org/java-string-format-examples/
		System.out.format("It's %1$s and cost is %2$d", cappuccinoCoffee.getDescription(), cappuccinoCoffee.getCost());
		
		Coffee cappuccinoCoffeeWithMilk = new MilkSpecialCoffee(cappuccinoCoffee);
		System.out.format("%nIt's %1$s and the cost is %2$d", cappuccinoCoffeeWithMilk.getDescription(), cappuccinoCoffeeWithMilk.getCost());
		
		Coffee espressoCoffee = new EspressoCoffee();
		
		Coffee espressoCoffeeWithSugar = new SugarSpeicalCoffee(espressoCoffee);
		System.out.format("%nIt's %1$s and cost is %2$d", espressoCoffeeWithSugar.getDescription(), espressoCoffeeWithSugar.getCost());
		
		Coffee espressoCoffeeWithSugarAndMilk = new MilkSpecialCoffee(espressoCoffeeWithSugar);
		System.out.format("%nIt's %1$s and cost: %2$d", espressoCoffeeWithSugarAndMilk.getDescription(), espressoCoffeeWithSugarAndMilk.getCost());
		
		

	}

}
