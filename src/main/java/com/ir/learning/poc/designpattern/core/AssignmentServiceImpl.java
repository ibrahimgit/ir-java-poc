package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.AssignmentService;
import com.ir.learning.poc.designpattern.Writer;

public class AssignmentServiceImpl implements AssignmentService {
	
	private Writer writer;
	
	public AssignmentServiceImpl(Writer writer) {
		this.writer = writer;
	}

	@Override
	public void writeAssignment(String text) {
		writer.write(text);
	}

}
