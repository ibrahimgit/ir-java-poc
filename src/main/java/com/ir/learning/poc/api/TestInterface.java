package com.ir.learning.poc.api;


@FunctionalInterface
public interface TestInterface {
	
	int foo(String str);
	
	default String doNothing(String str) {
		return str;
	}
	
	default void doStuff(int a) {
		System.out.println(a);
	}
	
	//void bar(); //it's functional interface

}
