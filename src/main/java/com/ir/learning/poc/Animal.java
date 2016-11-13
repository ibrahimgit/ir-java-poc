package com.ir.learning.poc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animal {
	
	private int y = 10;
	private static int x = 10;
	private static List<String> listStr = new ArrayList<String>();
	
	static {
		
		System.out.println("Animal static block x: " + x);
		x = 16;
		System.out.println("Animal static block x: " + x);
		//listStr.get(0);
		//throw new NullPointerException();
	}
	
	public Animal() {
		System.out.println("Animal Contrutor y : " + y);
	}
	
	public Number foo() throws IndexOutOfBoundsException {
		return 5;
	}
	
	public static void doStuff() {
		System.out.println("Animal doStuff");
	}

}
