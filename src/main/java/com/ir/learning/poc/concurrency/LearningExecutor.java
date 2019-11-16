package com.ir.learning.poc.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LearningExecutor {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exService = Executors.newFixedThreadPool(4); //TTL is until executor is shutdown
		
		Callable<String> service = () -> "Hello World: " + Thread.currentThread().getName();
		
		
		List<Callable<String>> services = Arrays.asList(service, service, service);
		
		List<Future<String>> futureResult = exService.invokeAll(services, 1, TimeUnit.SECONDS);
		
		for(Future<String> result : futureResult) {
			String message = result.get();
			log.info(message);
		}
		
		
		
		List<Callable<String>> services1 = Arrays.asList(service, service, service);
		
		List<Future<String>> futureResult1 = exService.invokeAll(services1, 2, TimeUnit.SECONDS);
		
		for(Future<String> result : futureResult1) {
			String message = result.get();
			log.info(message);
		}
		
		exService.shutdown();
		
		
//		futureResult.forEach(result -> {
//			try {
//				String message = result.get();
//				log.info(message);
//			} catch (InterruptedException | ExecutionException e) {
//				log.error(e.getMessage(), e);
//			}
//		});
		
		ExecutorService cachedPoolExectuor = Executors.newCachedThreadPool(); //TTL is 60 secs
		
		Callable<String> task = () -> {
			log.info("CachedThreadPool - going to execute task for thread: " + Thread.currentThread().getName());
			Thread.sleep(2000);
			return "CachedThreadPool - returning from " + Thread.currentThread().getName();
		};
		
		List<Future<String>> futureResponse = cachedPoolExectuor.invokeAll(Arrays.asList(task ,task, task, task, task));
		
		Thread.sleep(4000);
		
		List<Future<String>> futureResponse1 = cachedPoolExectuor.invokeAll(Arrays.asList(task ,task, task, task, task));
		
		for(Future<String> response : futureResponse) {
			String message = response.get();
			log.info(message);
		}
		
		for(Future<String> response : futureResponse1) {
			String message = response.get();
			log.info(message);
		}
		
		
		
		cachedPoolExectuor.shutdown();
		ExecutorService singlePoolExectuor = Executors.newSingleThreadExecutor(); //TTL is until it is shutdown
		
		Callable<String> task1 = () -> {
			log.info("SingleThreadExecutor - going to execute task for thread: " + Thread.currentThread().getName());
			Thread.sleep(5000);
			return "SingleThreadExecutor - returning from " + Thread.currentThread().getName();
		};
		
		List<Future<String>> futureResponse2 = singlePoolExectuor.invokeAll(Arrays.asList(task1 ,task1, task1, task1, task1));
		
		for(Future<String> response : futureResponse2) {
			String message = response.get();
			log.info(message);
		}
		
		singlePoolExectuor.shutdown();
		
	}

}
