package com.ir.learning.poc.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LearnCipher {

	private static final String ALGORITHM = "AES/CBC/PKCS5PADDING"; //"AES"
	private static final String SECRET_KEY = "4nh3743hkjh32h4b"; //the key should be 16 bytes
	// https://www.garykessler.net/library/crypto.html
	// Types of cryptography
	// 1. Secret Key Cryptography (SKC) or Symmetric Cryptography
	// 2. Public Key Cryptography (PKC) or Asymmetric Cryptography
	// 3. Hash Functions

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
		// This one is not working for simple key string, hence using KeyGenrator
		// If Cipher uses "AES/CBC/PKCS5PADDING" then use the IV Param to get it working
		// SecretKeySpec key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES")
		
		Key key = getKey();
		String message = "I am Ibrahim Rashid";
		String encryptedMessage = encryptMessage(key, message);
		//encryptedMessage = qAZZvLQW0ucS57jzotfETh9Z3KkizWUZOokED6/tWaU=
		log.debug("Encrypted message is {}", encryptedMessage); 
		String decryptedMessage = decryptMessage(key, encryptedMessage);
		log.debug("decrypted message is {}", decryptedMessage);
		
	}
	
	private static Key getKey() {
		return new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES"); //Use IV Param to get it working
	}
	
//	private static Key getKey() throws NoSuchAlgorithmException {
//		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//		keyGen.init(128);
//		return keyGen.generateKey();
//	}
	
	private static String encryptMessage(Key key, String message) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8)));
//		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] encryptedMsg = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
		
		// byte array must be converted into String using Base64 encoding
		//Base64Utils.encodeToString(encryptedMsg);
		//String encryptedMessage = new String(Base64.getEncoder().encode(encryptedMsg));
		return Base64.getEncoder().encodeToString(encryptedMsg);
	}
	
	private static String decryptMessage(Key key, String encryptedMessage) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		//it needs same cipher to decrypt the message as it needs IV params
		//cipher.init(Cipher.DECRYPT_MODE, key, cipher.getParameters());
		
		Cipher cipher = Cipher.getInstance(ALGORITHM);
//		cipher.init(Cipher.DECRYPT_MODE, key); //no IV works if Cipher algo is AES
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8)));


		byte[] decryptedMsg = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage)); 
		//This never works
		//byte[] decryptedMsg = cipher.doFinal(encryptedMessage.getBytes("UTF-8"));
		return new String(decryptedMsg);
	}

}
