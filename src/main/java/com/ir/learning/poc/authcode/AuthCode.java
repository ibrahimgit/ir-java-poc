package com.ir.learning.poc.authcode;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class AuthCode {
	
	
	private static final String SECRET_KEY = "fdgfd4453dfccgfeqwwrryughvbcvxsdaagnrtererfhklmy6756465vg";
	
	private static final String HMAC_ALGO = "HmacSHA256";
	
	private static Mac mac;
	
	static {
		try {
			initializeHMac();
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		
		String message = "I love Saba";
		byte[] messageBytes = mac.doFinal(message.getBytes());
		String encodedMessage = Base64.getEncoder().encodeToString(messageBytes);
		System.out.println("Encoded Message: " + encodedMessage);

	}

	private static void initializeHMac() throws NoSuchAlgorithmException, InvalidKeyException {
		mac = Mac.getInstance(HMAC_ALGO);
		SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), HMAC_ALGO);
		mac.init(key);
	}

}
