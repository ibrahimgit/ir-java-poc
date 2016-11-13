package com.ir.learning.poc.designpattern.bridge;

public class Assemble implements Workshop {

	@Override
	public void work() {
		System.out.println("Assemble");
	}

}
