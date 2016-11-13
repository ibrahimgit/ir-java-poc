package com.ir.learning.poc.domainmodel;

public class Student {
	
	private String name;
	private int age;
	private String address;
	private double salary;
	private long phoneNumber;
	private Subject subject;
	
	public Student() {
		
	}
	
	public Student(String name, int age, String address, double salary, long phoneNumber, Subject subject) {
		this.name= name;
		this.age = age;
		this.address = address;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.subject = subject;
	}
	
	
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
