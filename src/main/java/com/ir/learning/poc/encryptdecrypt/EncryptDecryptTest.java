package com.ir.learning.poc.encryptdecrypt;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptTest {
	
	private static final String SECRET_KEY = "123098xyzabc4567";
	
	public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException {
		
		
		
		AESALGO algo = new AESALGO();
		String message = "I want my Saba back";
		byte[] encryptedMessage = algo.encrypt(message.getBytes());
		String encryptedEncodedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
		System.out.println("Encrypted message: " + new String(encryptedMessage));
		System.out.println("Encrypted and Encoded message: " + encryptedEncodedMessage);
		
		//byte[] decodedMessage = Base64.getDecoder().decode(encryptedEncodedMessage.getBytes());
		byte[] dycryptedMessage = algo.decrypt(encryptedMessage);
		System.out.println("Dycrypted message: " + new String(dycryptedMessage));
		
		
		
		RSAAlgo rsaAlgo = new RSAAlgo();
		encryptedMessage = rsaAlgo.encrpytMessage(message.getBytes());
		dycryptedMessage = rsaAlgo.decrpytMessage(encryptedMessage);
		//System.out.println("RSA Dycrypted message: " + new String(dycryptedMessage));
		
		
	}
	
	private static class AESALGO {
		
		
		private static final String ALGO = "AES";
		
		private static Cipher cipherEncrypt;
		private static Cipher cipherDecrypt;
		
		static {
			//Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGO);
			try {
				KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
				keyGen.init(128);
				SecretKey secretKey = keyGen.generateKey();
				System.out.println("secret key: " + new String(secretKey.getEncoded()));
				cipherEncrypt = Cipher.getInstance(ALGO);
				cipherEncrypt.init(Cipher.ENCRYPT_MODE, secretKey);
				cipherDecrypt = Cipher.getInstance(ALGO);
				cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKey);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		public byte[] encrypt(byte[] data) throws IllegalBlockSizeException, BadPaddingException {
			return cipherEncrypt.doFinal(data);
		}
		
		public byte[] decrypt(byte[] data) throws IllegalBlockSizeException, BadPaddingException {
			return cipherDecrypt.doFinal(data);
		}
		
	}
	
	
	private static class RSAAlgo {
		
		private static final String ALGO = "RSA";
		private static Cipher encryptCipher;
		private static Cipher decryptCipher;
		
		public RSAAlgo () {
			try {
				KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGO);
				kpg.initialize(512);
				KeyPair keyPair = kpg.genKeyPair();
				PublicKey publicKey = keyPair.getPublic();
				PrivateKey privateKey = keyPair.getPrivate();
				encryptCipher = Cipher.getInstance(ALGO);
				encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
				decryptCipher = Cipher.getInstance(ALGO);
				decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
				
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		
		public byte[] encrpytMessage(byte[] message) throws IllegalBlockSizeException, BadPaddingException {
			return encryptCipher.doFinal(message);
		}
		
		public byte[] decrpytMessage(byte[] message) throws IllegalBlockSizeException, BadPaddingException {
			return encryptCipher.doFinal(message);
		}

	}

}
