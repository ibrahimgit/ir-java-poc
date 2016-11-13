package com.ir.learning.poc.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		getUidPwd();
		//getbrowsertype();
		//getDeviceID();


	}

	private static void getDeviceID() throws IOException {

		System.out.println("Started");
		File file = new File("deviceid.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			System.out.println("File doesn't exists");
			file.createNewFile();
			System.out.println("created");
		}
		
		List<String> uuids = new ArrayList<>();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String randomNum = null;
		for(int i = 0; i<2000; i++) {
			randomNum = UUID.randomUUID().toString();
			bw.write(randomNum);
			bw.newLine();
			uuids.add(randomNum);
		}
		int count = 0;
		for(String uuid : uuids) {
			for(String uui : uuids) {
				if(uuid.equals(uui)) {
					count++;
				}
			}
		}
		System.out.println("Count: " + count);
		System.out.println("Done");
		bw.close();
	
		
	
		// TODO Auto-generated method stub
		
	}

	private static void getbrowsertype() throws IOException {

		System.out.println("Started");
		File file = new File("devietype.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			System.out.println("File doesn't exists");
			file.createNewFile();
			System.out.println("created");
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String deviceType = null;
		for(int i = 0; i<2000; i++) {
			deviceType = "browser";
			bw.write(deviceType);
			bw.newLine();
		}
		System.out.println("Done");
		bw.close();
	
		
	}

	private static void getUidPwd() throws IOException {
		System.out.println("Started");
		File file = new File("username1.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			System.out.println("File doesn't exists");
			file.createNewFile();
			System.out.println("created");
		}
		
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String uidpwd = null;
		for(int i = 0; i<63; i++) {
			uidpwd = "Heroher1,test@123";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "demod1,Sparks1234";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "SmithD12,driver@123";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "SmithJo12,driver@123";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "winrunrdi1,Summer19!";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "eschell,Element1!";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "srosati,Sparks123";
			bw.write(uidpwd);
			bw.newLine();
			uidpwd = "amckeegan,driver@123";
			bw.write(uidpwd);
			bw.newLine();
		}
		System.out.println("Done");
		bw.close();
	}

}
