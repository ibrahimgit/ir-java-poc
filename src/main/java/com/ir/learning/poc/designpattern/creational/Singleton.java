package com.ir.learning.poc.designpattern.creational;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Singleton {
	
	// private static final Singleton instance = new Singleton() // eager initialization
	
	private static Singleton instance = null;
	
//	static {
//		instance = new Singleton() // eager initialization through static block
//	}
	
	private Singleton() {
	}
	
//	public static Singleton getInstance() {
//		return instance //eager initialization
//	}
	
//	public static Singleton getInstance() {
//		if(instance == null ) {
//			instance = new Singleton() //not thread safe
//		}
//		return instance; 
//	}
	
//	public static synchronized Singleton getInstance() {
//		if(instance == null ) {
//			instance = new Singleton(); //thread safe but too causing thread block and waiting
//		}
//		return instance; 
//	}
	
//	public static Singleton getInstance() {
//		if(instance == null) {
//			synchronized (Singleton.class) { //double checked locking
//				if(instance == null)
//					instance = new Singleton();
//			}
//			
//		}
//		return instance;
//	}
	
	public static Singleton getInstance() {
		log.info("fetching singleton instance");
		return InnerSingleton.instance; //This is the best approach
	}
	
	//This inner class is not loaded until called for first time 
	private static class InnerSingleton { //Bill Pugh Singleton Implementation
		private static final Singleton instance = new Singleton(); 
		static {
			log.info("Initializing the inner class");
		}
	}

}
