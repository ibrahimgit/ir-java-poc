package com.ir.learning.poc.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LearningHash {
	
	private static final String HEX_FORMATTER = "%1$0{0}x";

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//Algorithm for hashing is MD5, SHA-1, SHA-256, SHA-512
		String message = "I am Ibrahim Rashid. This is a big message. This is ver very big message";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashArray = md.digest(message.getBytes("UTF-8"));
		//convert it into it hexString
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < hashArray.length; i++) {
	        stringBuffer.append(Integer.toString((hashArray[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
		log.debug("Hash: {}", stringBuffer);
		//9d4501445640b5bd8bdcc0fd4396b52ae61ab96777ccee89c1c934ba637b3abd
		//https://www.baeldung.com/sha-256-hashing-java
		String encodedMessage = encodeData(message, 10);
		log.info("encoded data: {}", encodedMessage);
		
	}
	
	private static String encodeData(String message, Integer messageSize) {
		
		Integer messageHash = DigestUtils.sha256Hex(message).hashCode();
		String encodedMessage = String.format(MessageFormat.format(HEX_FORMATTER, messageSize), messageHash);
		return encodedMessage;
	}

}
