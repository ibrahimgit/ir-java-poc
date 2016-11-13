package com.ir.learning.poc.designpattern.decorator;

public class CoffeWithSugarDecorator implements Coffe{
	
	private Coffe coffe;
	
	private int price = 15;
	
	public CoffeWithSugarDecorator(Coffe coffe) {
		this.coffe = coffe;
	}
	

	@Override
	public int price() {
		return coffe.price() + price;
	}

}
