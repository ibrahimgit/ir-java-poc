package com.ir.learning.poc.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTesting {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new CalculateThread(10, 20), "calc thread");
		Thread t2 = new Thread(new PrintThread(), "print thread");
		
		Thread t3 = Thread.currentThread();
		t3.setName("ThreadTesting");
		
		t1.start();
		t2.start();
		
		log.info("Alive? " + t3.isAlive());
		
		log.info("t3: " + t3);
		
		

	}

}
