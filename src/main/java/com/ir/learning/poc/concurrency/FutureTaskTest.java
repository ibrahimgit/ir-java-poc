package com.ir.learning.poc.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTaskTest {
	
	
	
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		System.out.println("Initializing the job...");
		Future<Boolean> futureTask = newCachedThreadPool.submit(new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				System.out.println(" I am called");
				Thread.sleep(10000);
				System.out.println(" I am finished");
				return Boolean.TRUE;
			}
		});
		System.out.println("Job Submitted....");
		Boolean response = false;
		try {
			response = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Got the response.... " + response);
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("*****called when program is terminated.....");
			}
		});
		
		System.exit(0);
	}

}
