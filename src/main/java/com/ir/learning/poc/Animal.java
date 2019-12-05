package com.ir.learning.poc;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Animal {
	
	private int y = 10;
	private static int x = 10;
	private static List<String> listStr = new ArrayList<String>();
	
	static {
		
		log.info("Animal static block x: " + x);
		x = 16;
		log.info("Animal static block x: " + x);
		//listStr.get(0);
		//throw new NullPointerException();
	}
	
	public Animal() {
		log.info("Animal Contrutor y : " + y);
	}
	
	public Number foo() throws IndexOutOfBoundsException {
		return 5;
	}
	
	public static void doStuff() {
		log.info("Animal doStuff");
	}

}
