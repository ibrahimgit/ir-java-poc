package com.ir.learning.poc;

public final class ImmutableClass {
	
	private final int x;
	private final String s;
	//HashSet<String> s = new HashSet<String>();
	
	private ImmutableClass(int x, String s) {
		this.x = x;
		this.s = s;
	}
	
	public int getX() {
		return x;
	}
	
	public String getS() {
		return s;
	}

}
