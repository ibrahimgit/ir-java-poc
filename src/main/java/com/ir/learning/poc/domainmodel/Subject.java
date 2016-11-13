package com.ir.learning.poc.domainmodel;

public class Subject {
	
	private String name;
	private String standard;
	private int passMarks;
	
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(String name, String standard, int passMarks) {
		super();
		this.name = name;
		this.standard = standard;
		this.passMarks = passMarks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public int getPassMarks() {
		return passMarks;
	}
	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}
	
	

}
