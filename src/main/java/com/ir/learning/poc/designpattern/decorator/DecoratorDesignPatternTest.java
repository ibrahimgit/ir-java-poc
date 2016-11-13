package com.ir.learning.poc.designpattern.decorator;

public class DecoratorDesignPatternTest {

	public static void main(String[] args) {
		
		Coffe milkCoffe = new MilkCoffe();
		Coffe blackCoffe = new BlackCoffe();
		
		Coffe milkCoffeWithSugar = new CoffeWithSugarDecorator(milkCoffe);
		
		Coffe blackCoffeWithSugar = new CoffeWithSugarDecorator(blackCoffe);
		
		System.out.println("Milk Coffe price: " + milkCoffe.price());
		System.out.println("Black Coffe price: " + blackCoffe.price());
		System.out.println("Milk Coffe with sugar price: " + milkCoffeWithSugar.price());
		System.out.println("Black Coffe with sugar price: " + blackCoffeWithSugar.price());
		

	}

}
