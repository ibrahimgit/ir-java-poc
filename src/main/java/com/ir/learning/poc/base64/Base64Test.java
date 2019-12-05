package com.ir.learning.poc.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.apache.log4j.Logger;

public class Base64Test {
	
	public static final String STRING_CONSTANT = "Ibrahim Rashid";
	
	private static final Logger LOGGER = Logger.getLogger(Base64Test.class);

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		
		Encoder encoder = Base64.getEncoder();
		byte[] encodedMsg = encoder.encode(STRING_CONSTANT.getBytes("UTF-8"));
		String encodedStrMsg = encoder.encodeToString(STRING_CONSTANT.getBytes("UTF-8"));
		LOGGER.info("Encoded Messsage: " + encodedMsg.toString());
		LOGGER.info("Encoded String Messsage1: " + new String(encodedMsg));
		LOGGER.info("Encoded String Messsage2: " + encodedStrMsg);
		
		
		Encoder urlEncoder = Base64.getUrlEncoder();
		byte[] encodedURLMsg = urlEncoder.encode(STRING_CONSTANT.getBytes("UTF-8"));
		String encodedURLStrMsg = urlEncoder.encodeToString(STRING_CONSTANT.getBytes("UTF-8"));
		LOGGER.info("EncodedURL Messsage: " + encodedURLMsg.toString());
		LOGGER.info("EncodedURL String Messsage1: " + new String(encodedURLMsg));
		LOGGER.info("EncodedURL String Messsage2: " + encodedURLStrMsg);
		
		
		
		
		Decoder decoder = Base64.getDecoder();
		byte[] decodedMessage = decoder.decode(encodedMsg);
		String decodedStringMsg = new String(decodedMessage);
		LOGGER.debug("Decoded String Message: " + decodedStringMsg);
		
		Decoder mimeDecoder = Base64.getMimeDecoder();
		byte[] mimeDecoderDecodedMsg = mimeDecoder.decode(encodedMsg);
		LOGGER.debug("MIME Decoder Decoded String Message: " + new String(mimeDecoderDecodedMsg));
		
		Base64EncodingUsingApacheCommons();
		

	}

	private static void Base64EncodingUsingApacheCommons() throws UnsupportedEncodingException {
		byte[] encodedMsg = org.apache.commons.codec.binary.Base64.encodeBase64(STRING_CONSTANT.getBytes("UTF-8"));
		LOGGER.info("Commons codec - Encoded Messsage: " + encodedMsg);
		LOGGER.info("Commons codec - Encoded String Messsage: " + new String(encodedMsg));
		
		byte[] decodedMsg = org.apache.commons.codec.binary.Base64.decodeBase64(encodedMsg);
		LOGGER.info("Commons codec - Decoded String Messsage: " + new String(decodedMsg));
	}

}
