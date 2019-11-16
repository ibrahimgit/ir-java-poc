package com.ir.learning.poc.designpattern.structural;

import com.ir.learning.poc.designpattern.AssignmentService;
import com.ir.learning.poc.designpattern.Writer;
import com.ir.learning.poc.designpattern.core.AssignmentServiceImpl;
import com.ir.learning.poc.designpattern.factory.WriterFactory;
import com.ir.learning.poc.designpattern.factory.WriterFactory.Pen;

public class AdapterDesignPatternTest {
	
	//The bridge pattern looks a lot like the adapter pattern and is a common cause of confusion.
	
	//	Convert the interface of a class into another interface clients expect. 
	// Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.

	public static void main(String[] args) {
		String text = "I am Ibrahim Rashid";
		Writer writer = WriterFactory.getInstance(Pen.BALL_PEN);
		AssignmentService assignment = new AssignmentServiceImpl(writer);
		assignment.writeAssignment(text);
		
		writer = WriterFactory.getInstance(Pen.INK_PEN);
		assignment = new AssignmentServiceImpl(writer);
		assignment.writeAssignment(text);
		
		writer = WriterFactory.getInstance(Pen.MARKER);
		assignment = new AssignmentServiceImpl(writer);
		assignment.writeAssignment(text);
	}

}
