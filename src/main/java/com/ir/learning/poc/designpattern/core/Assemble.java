package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Workshop;

public class Assemble implements Workshop {

	@Override
	public void work() {
		System.out.println("Assemble");
	}

}
