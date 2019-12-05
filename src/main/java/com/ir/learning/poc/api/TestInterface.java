package com.ir.learning.poc.api;

import org.apache.log4j.Logger;

@FunctionalInterface
public interface TestInterface {
	
	public static final Logger LOGGER = Logger.getLogger(TestInterface.class);
	
	int foo(String str);
	
	default String doNothing(String str) {
		return str;
	}
	
	default void doStuff(int a) {
		LOGGER.info(a);
	}
	
	//void bar(); //it's functional interface

}
