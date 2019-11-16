package com.ir.learning.poc.jdk9;

import java.util.Random;

public interface InterafaceWithPrivateMethod {
	
	default String getName(String name) { //introduced in jdk 8
		return "My" + name;
	}
	
	default Integer getRandomNumber() { //introduced in jdk 8
		return new Random().nextInt(1000);
	}
	
	default Integer getArgumentCount(String v1, String v2) { //introduced in jdk 8
		return getCount(v1, v2);
	}
	
	private Integer getCount(String... data) { //introduced in jdk 9
		return data.length;
	}

}
