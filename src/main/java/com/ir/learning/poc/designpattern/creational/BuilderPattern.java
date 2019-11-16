package com.ir.learning.poc.designpattern.creational;

import java.util.Date;

public class BuilderPattern {
	
	private final Long id;
	private final String name;
	private final Date dob;
	
	private BuilderPattern(BuilderPatternBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.dob = builder.dob;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getDob() {
		return dob;
	}
	
	public static BuilderPatternBuilder builder() {
		return new BuilderPatternBuilder();
	}
	
	public static class BuilderPatternBuilder {
		private Long id;
		private String name;
		private Date dob;
		
		public BuilderPatternBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public BuilderPatternBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public BuilderPatternBuilder dob(Date dob) {
			this.dob = dob;
			return this;
		}
		
		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}
	
	@Override
	public String toString() {
		return "[id: " + this.id + ", name: " + this.name + ", dob: " + this.dob + "]";
	}

}
