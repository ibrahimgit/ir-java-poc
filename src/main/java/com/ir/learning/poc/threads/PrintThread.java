package com.ir.learning.poc.threads;

public class PrintThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Print Thread");
	}

}
