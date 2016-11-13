package com.ir.learning.poc;

import com.ir.learning.poc.api.TestInterface;

public class TestImpl implements TestInterface {

	@Override
	public int foo(String str) {
		return 0;
	}
	
	@Override
	public String doNothing(String str) {
		return ""; //TestInterface.super.doNothing(str);
	}

}
