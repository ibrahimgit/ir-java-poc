package com.ir.learning.poc.designpattern.factory;


import com.ir.learning.poc.designpattern.Writer;
import com.ir.learning.poc.designpattern.core.BallPenWriter;
import com.ir.learning.poc.designpattern.core.InkPenWriter;
import com.ir.learning.poc.designpattern.core.Marker;
import com.ir.learning.poc.designpattern.core.MarkerWriterAdapter;

public class WriterFactory {
	
	public enum Pen {
		BALL_PEN, INK_PEN, MARKER
	}

	public static Writer getInstance(Pen type) {
		Writer writer = null;
		switch(type) {
		case BALL_PEN: 
			writer = new BallPenWriter();
			break;
		case INK_PEN: 
			writer = new InkPenWriter();
			break;
		case MARKER:
			Marker marker = new Marker();
			writer = new MarkerWriterAdapter(marker);
			break;
		default:
			break;
		}
		return writer;
	}
}
