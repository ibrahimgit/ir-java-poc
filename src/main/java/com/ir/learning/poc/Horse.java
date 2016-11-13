package com.ir.learning.poc;

import java.io.IOException;

public class Horse extends Animal implements Cloneable{
	
	int y;
	
	public static void doStuff(){
		System.out.println("do Stuff in Horse");
	}
	
	@Override
	public Integer foo() throws NullPointerException {
		// TODO Auto-generated method stub
		return 5;
	}
	
	int bar() throws IOException {
		Horse.AHorse aah = new Horse.AHorse(5);
		aah.aaa();
		return 3;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	private String bar(int x) throws ClassCastException {
		return "";
	}
	
	
	public class AHorse {
		
		int x;
		
		AHorse(int x) {
			this.x = x;
		}
		
		int aaa() {
			return x+y;
		}
		
		
		
	}
	
	

}
