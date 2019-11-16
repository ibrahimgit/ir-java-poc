package com.ir.learning.poc.designpattern.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ir.learning.poc.designpattern.Writer;

@Service
public class MarkerWriterAdapter implements Writer {
	
	// The bridge pattern looks a lot like the adapter pattern and is a common cause of confusion.
	// Adapter makes things work after they’re designed; Bridge makes them work before they are.
	
	@Autowired
	private Marker marker;
	
	public MarkerWriterAdapter(Marker marker) {
		this.marker = marker;
	}

	@Override
	public void write(String text) {
		marker.mark(text);
	}

}
