package com.ir.learning.poc.designpattern.creational;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CreationalDesignPatternTest {
	
	public static void main(String[] args) {
		test_singleton();
		test_builder();
	}

	private static void test_singleton() {
		//Singleton singeton = new Singleton(); // error as no arg constructor is private
		
		Singleton singeton1 = Singleton.getInstance();
		Singleton singeton2 = Singleton.getInstance();
		
		log.info("Singleton Implemented? {}", singeton1 == singeton2);
		// Assert.isTrue(singeton1 == singeton2, "This is not a singleton implementation");
	}
	
	private static void test_builder() {
		BuilderPattern instance1 = BuilderPattern.builder().id(111L).name("test").build();
		log.info("{}", instance1);
		BuilderPattern instance2 = BuilderPattern.builder().id(111L).build();
		log.info("{}", instance2);
		BuilderPattern instance3 = BuilderPattern.builder().id(111L).name("name").dob(new Date()).build();
		log.info("{}", instance3);
		
	}

}
