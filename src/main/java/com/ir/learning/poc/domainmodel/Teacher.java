package com.ir.learning.poc.domainmodel;

public class Teacher {
	
	private String name;
	private String subjectTeacher;
	private int age;
	private Student student;
	
	
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String subjectTeacher, int age, Student student) {
		super();
		this.name = name;
		this.subjectTeacher = subjectTeacher;
		this.age = age;
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubjectTeacher() {
		return subjectTeacher;
	}
	public void setSubjectTeacher(String subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
