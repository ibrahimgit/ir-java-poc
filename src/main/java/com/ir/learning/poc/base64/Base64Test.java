package com.ir.learning.poc.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Test {
	
	public static final String STRING_CONSTANT = "Ibrahim Rashid";

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		
		Encoder encoder = Base64.getEncoder();
		byte[] encodedMsg = encoder.encode(STRING_CONSTANT.getBytes("UTF-8"));
		String encodedStrMsg = encoder.encodeToString(STRING_CONSTANT.getBytes("UTF-8"));
		System.out.println("Encoded Messsage: " + encodedMsg.toString());
		System.out.println("Encoded String Messsage1: " + new String(encodedMsg));
		System.out.println("Encoded String Messsage2: " + encodedStrMsg);
		
		
		Encoder urlEncoder = Base64.getUrlEncoder();
		byte[] encodedURLMsg = urlEncoder.encode(STRING_CONSTANT.getBytes("UTF-8"));
		String encodedURLStrMsg = urlEncoder.encodeToString(STRING_CONSTANT.getBytes("UTF-8"));
		System.out.println("EncodedURL Messsage: " + encodedURLMsg.toString());
		System.out.println("EncodedURL String Messsage1: " + new String(encodedURLMsg));
		System.out.println("EncodedURL String Messsage2: " + encodedURLStrMsg);
		
		
		
		
		Decoder decoder = Base64.getDecoder();
		byte[] decodedMessage = decoder.decode(encodedMsg);
		String decodedStringMsg = new String(decodedMessage);
		System.out.println("Decoded String Message: " + decodedStringMsg);
		
		Decoder mimeDecoder = Base64.getMimeDecoder();
		byte[] mimeDecoderDecodedMsg = mimeDecoder.decode(encodedMsg);
		System.out.println("MIME Decoder Decoded String Message: " + new String(mimeDecoderDecodedMsg));
		
		Base64EncodingUsingApacheCommons();
		

	}

	private static void Base64EncodingUsingApacheCommons() throws UnsupportedEncodingException {
		byte[] encodedMsg = org.apache.commons.codec.binary.Base64.encodeBase64(STRING_CONSTANT.getBytes("UTF-8"));
		System.out.println("Commons codec - Encoded Messsage: " + encodedMsg);
		System.out.println("Commons codec - Encoded String Messsage: " + new String(encodedMsg));
		
		byte[] decodedMsg = org.apache.commons.codec.binary.Base64.decodeBase64(encodedMsg);
		System.out.println("Commons codec - Decoded String Messsage: " + new String(decodedMsg));
	}

}
