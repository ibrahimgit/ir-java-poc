package com.ir.learning.poc.designpattern.builder;

public class BuilderDesignPatternTest {
	
	public static void main(String[] args) {
		Cake cake = new Cake.CakeBuilder().milk(2.0f).egg(2).sugar(1.0f).build();
		
		System.out.println("Your cake: " + cake.toString());
	}

}

