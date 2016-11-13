package com.ir.learning.poc.threads;

public class CalculateThread implements Runnable {
	
	int x;
	int y;
	
	public CalculateThread(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		
		System.out.println("Sum: " + (x + y));

	}

}
