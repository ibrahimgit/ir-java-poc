package com.ir.learning.poc.designpattern.bridge;

public class Produce implements Workshop {

	@Override
	public void work() {
		System.out.println("Produce");

	}

}
