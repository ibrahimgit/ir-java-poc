package com.ir.learning.poc.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileTest {

	public static void main(String[] args) throws IOException {
		
		//getUidPwd();
		//getbrowsertype();
		//getDeviceID();
		downloadAndCopyAFile();
		//byte[] bytes = readPDF();
		//createPDF(bytes);
		//bytes = readXcelSheet();
		//WriteToXcelSheet(bytes);

	}

	private static void WriteToXcelSheet(byte[] bytes) throws IOException {
		takeBackUp();
		Path writingPath = Paths.get("test/xls/test.xls");
		Files.write(writingPath, bytes);
		
	}

	private static void takeBackUp() throws IOException {
		Path readingPath = Paths.get("test/xls/test.xls");
		Path backupPath = Paths.get("test/xls/test-backup.xls");
		Files.copy(readingPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
	}

	private static byte[] readXcelSheet() throws IOException {
		Path readingPath = Paths.get("test/xls/Jenkins Setup.xls");
		return Files.readAllBytes(readingPath);
	}

	private static void createPDF(byte[] bytes) throws IOException {
		
		//String pdfString = Base64.getEncoder().encodeToString(bytes);
		
		/*File newPDFFile = new File("test/pdf/new-file.pdf");
		FileOutputStream fos = new FileOutputStream(newPDFFile);*/
		
		Path path = Paths.get("test/pdf/new-file.pdf");
		Files.write(path, bytes);
		
	}

	private static byte[] readPDF() throws FileNotFoundException, IOException {
		//Using the File input Stream
		/*File file = new File("test/pdf/spring-boot-reference.pdf");
		int length = (int)file.length();
		FileInputStream fis = new FileInputStream(file);
		byte[] bytes = new byte[length];
		fis.read(bytes, 0, length);*/
		
		//Using the Paths and Files
		Path path = Paths.get("test/pdf/spring-boot-reference.pdf");
		byte[] bytes = Files.readAllBytes(path);
		
		
		return bytes;
	}

	private static void downloadAndCopyAFile() throws IOException {
		String fileURLString = "http://docs.spring.io/spring-boot/docs/current/reference/pdf/spring-boot-reference.pdf";
		String filePath = "test/pdf/spring-boot-reference.pdf";
		File targetFile = new File(filePath);
		URL fileURL = new URL(fileURLString);
		File destination = new File("test/pdf/spring-boot-reference-new.pdf");
		log.info("starting.......");
		FileUtils.copyURLToFile(fileURL, targetFile);
		log.info("copy from url done....");
		// FileUtils.copyToFile("dsdssaadsdas".getBytes(), destination);
		FileCopyUtils.copy(targetFile, destination);
		log.info("copy from file to file done");
		
		HttpURLConnection connection = (HttpURLConnection) fileURL.openConnection();
		if(connection.getResponseCode() == HttpStatus.SC_OK) {
			Map<String, List<String>> headerFields = connection.getHeaderFields();
			log.info("headers: {}", headerFields);
			String headerField = connection.getHeaderField("Content-Disposition");
			log.info(headerField);
		}
		
		
		
		File testDirectory = new File("F:\\My Workspace\\ir-java-poc");
		log.info("This is a directory: " + testDirectory.isDirectory());
		
		File testFile = new File("test/ibrahim/abc");
		
		
		if(!testFile.exists()) {
			log.info("doesn't exist");
			if(testFile.isDirectory()) {
				log.info("It's directory path");
			} else {
				log.info("It's not directory path");
				boolean mkdir = testFile.mkdir();
				log.info("Directory created: " + mkdir);
			}
				
		}
		
		
		
	}

	private static void getDeviceID() throws IOException {

		log.info("Started");
		File file = new File("deviceid.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			log.info("File doesn't exists");
			file.createNewFile();
			log.info("created");
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
		log.info("Count: " + count);
		log.info("Done");
		bw.close();
	
		
	
		// TODO Auto-generated method stub
		
	}

	private static void getbrowsertype() throws IOException {

		log.info("Started");
		File file = new File("devietype.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			log.info("File doesn't exists");
			file.createNewFile();
			log.info("created");
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String deviceType = null;
		for(int i = 0; i<2000; i++) {
			deviceType = "browser";
			bw.write(deviceType);
			bw.newLine();
		}
		log.info("Done");
		bw.close();
	
		
	}

	private static void getUidPwd() throws IOException {
		log.info("Started");
		File file = new File("username1.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			log.info("File doesn't exists");
			file.createNewFile();
			log.info("created");
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
		log.info("Done");
		bw.close();
	}

}
