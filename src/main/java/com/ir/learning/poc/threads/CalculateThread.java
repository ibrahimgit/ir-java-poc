package com.ir.learning.poc.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculateThread implements Runnable {
	
	int x;
	int y;
	
	public CalculateThread(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		
		log.info("Sum: " + (x + y));

	}

}
