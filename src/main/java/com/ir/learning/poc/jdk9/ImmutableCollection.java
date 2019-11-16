package com.ir.learning.poc.jdk9;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableCollection {
	
	// Java 8 way
	public Set<String> getJava8ImmutableSet(String... data) {
		Set<String> values = new HashSet<>();
		values.addAll(Arrays.asList(data));
		
		return Collections.unmodifiableSet(values);
	}
	
	// Java 8 way
	public Set<String> getJava9ImmutableSet(String... data) {
		return Set.of(data);
	}

}
