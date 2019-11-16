package com.ir.learning.poc.designpattern.core;

import org.springframework.stereotype.Service;

import com.ir.learning.poc.designpattern.AssignmentService;
import com.ir.learning.poc.designpattern.Writer;

@Service
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
