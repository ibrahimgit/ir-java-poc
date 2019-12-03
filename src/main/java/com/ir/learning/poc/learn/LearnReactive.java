package com.ir.learning.poc.learn;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ir.learning.poc.domainmodel.Employee;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

public class LearnReactive {
	
	
	
	public static void main(String[] args) {
		// Publisher -> Subscriber
		// Subject -> Observer
		// Observable -> Observer/Subscriber
		// Observable just register any data stream stream. The source will output the data only if a subscriber/observer is connected
		Observable<Employee> dataStream = getObservable();
		
		System.out.println("observable set");
		
		//subscribeBySubscriber(dataStream);
		subscribeByObserver(dataStream);
//		subscribeByAction(dataStream);
//		Stream.of("A", "B", "C", "D", "E", "F").forEach(val -> {
//			try {
//				Thread.sleep(1000l);
//			} catch (InterruptedException e1) {
//				System.err.println(e1);
//			}
//			System.out.println(val);
//		});
		
		
	}
	
	private static Observable<Employee> getObservable() {
		Employee emp1 = Employee.builder().name("name").build();
		Employee emp2 = Employee.builder().name("gane").gender("A").build();
		List<Employee> employees = List.of(emp1, emp2);
		return Observable.from(employees);
	}

	private static Observable<Employee> getObservable1() {
		return Observable
				.fromCallable(() -> {
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<Employee> response = restTemplate.exchange("http://localhost:8080/ir/microservice/employees/{empId}", HttpMethod.GET, null, Employee.class, 4);
					return response.getBody();
				});
	}
	
	private static void subscribeBySubscriber(Observable<Employee> dataStream) {
		System.out.println("subscribing a blocking subscriber");
		dataStream.subscribe(new Subscriber<Employee>() {

			@Override
			public void onCompleted() {
				System.out.println("done");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e);
			}

			@Override
			public void onNext(Employee emp) {
				System.out.println(emp);
				
			}
			
		});
		System.out.println("Observer1 set");
		dataStream.subscribe(new Subscriber<Employee>() {

			@Override
			public void onCompleted() {
				System.out.println("completed");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e);
			}

			@Override
			public void onNext(Employee emp) {
				System.out.println(emp.getName());
				
			}
			
		});
		System.out.println("Observer2 set");
	}
	
	private static void subscribeByObserver(Observable<Employee> dataStream) {
		System.out.println("subscribing a blocking observer");
		dataStream.subscribe(new Observer<Employee>() {

			@Override
			public void onCompleted() {
				System.out.println("done");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e);
			}

			@Override
			public void onNext(Employee emp) {
				System.out.println(emp);
				
			}
			
		});
		System.out.println("Observer1 set");
	}

	private static void subscribeByAction(Observable<Employee> dataStream) {
		System.out.println("subscribing a blocking observer by action");
		dataStream.subscribe(emp -> {System.out.println(emp);}, e -> {System.err.println(e);}, () -> {System.out.println("done");});
//		System.out.println("Observer1 set");
//		dataStream.subscribe(emp1 -> {System.out.println(emp1.getName());}, e -> {}, () -> {System.out.println("done");});
//		System.out.println("Observer2 set");
	}

}
