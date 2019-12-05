package com.ir.learning.poc.resttemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class RestTemplateTest {
	
	private static final Logger LOGGER = Logger.getLogger(RestTemplateTest.class);
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		RestTemplate rt = new RestTemplate();
		
		//String str = rt.getForObject("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=907f14649dd7564b21d2d4a61d954414", String.class);
		
		
		//LOGGER.info(str);
		//System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Ibrahim Rashid\\Desktop\\keystore");
		//LOGGER.info(rt.getForObject("https://api-xceleratedriver.prod.elementfleet.com/service/data/security/login", String.class));
		
		//callPaymentProcessor();
		
				callHttpClient();
	}
	
	
	private static void callHttpClient() throws ParserConfigurationException, SAXException {
		LOGGER.info("\ncallHttpClient ");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = "https://orbitalvar1.paymentech.net/authorize";
		String str = "<?xml version=\"1.0\"?>  <Request>   <Profile>   <OrbitalConnectionUsername>TEVMS6578</OrbitalConnectionUsername>  <OrbitalConnectionPassword>Y3PQ8ZCG1</OrbitalConnectionPassword> <CustomerBin>000001</CustomerBin> <CustomerMerchantID>249476</CustomerMerchantID> <CustomerRefNum>4049</CustomerRefNum> <CustomerProfileAction>R</CustomerProfileAction> </Profile> </Request>";
		HttpPost post = new HttpPost(url);
		
		post.setHeader("MIME-Version", "1.0");
		post.setHeader("Content-Type", "application/PTI62");
		//post.setHeader("Content-length", String.valueOf(str.length()));
		post.setHeader("Request-number", "1"); 
		post.setHeader("Document-type", "Request");
		post.setHeader("Content-transfer-encoding", "text");
		//HttpEntity
		BufferedReader rd = null;
		try {
		StringEntity se = new StringEntity(str);
		post.setEntity(se);
		LOGGER.info("\ngoing to hit : " + url);
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();

		LOGGER.info("\nSending 'POST' request to URL : " + url);
		//LOGGER.info("Post parameters : " + postParams);
		LOGGER.info("Response Code : " + responseCode);
		
		rd = new BufferedReader(
	                new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		LOGGER.info(result.toString());
		httpClient.close();
		rd.close();
		praseXML(result.toString());
		} catch (IOException ie) {
			
		} finally {
			
			if (httpClient != null) {
				try {
					httpClient.close();
					LOGGER.info("httpClient: " + httpClient);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (rd != null) {
				try {
					rd.close();
					LOGGER.info("rd: " + rd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}


	private static String callPaymentProcessor() throws ParserConfigurationException, SAXException, IOException{
        String url = "https://orbitalvar1.paymentech.net/authorize";
        //String url= "https://orbitalvar1.paymentech.net/authorize";
        //RestTemplate callpayment = new RestTemplate(); Content-transfer-encoding
        //String s = "<";
        String str = "<?xml version=\"1.0\"?>  <Request>   <Profile>   <OrbitalConnectionUsername>TEVMS6578</OrbitalConnectionUsername>  <OrbitalConnectionPassword>Y3PQ8ZCG1</OrbitalConnectionPassword> <CustomerBin>000001</CustomerBin> <CustomerMerchantID>249476</CustomerMerchantID> <CustomerRefNum>4049</CustomerRefNum> <CustomerProfileAction>R</CustomerProfileAction> </Profile> </Request>";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("MIME-Version", "1.0");
        headers.add("Content-Type", "application/PTI62");
        headers.add("Content-length", String.valueOf(str.length()));
        headers.add("Request-number", "1"); 
        headers.add("Document-type", "Request");
        //headers.set("Content-transfer-encoding", "text");
        headers.add(HttpHeaders.CONTENT_ENCODING, "text");
        headers.add(HttpHeaders.TRANSFER_ENCODING, "text");
        
        //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<String> request = new HttpEntity<String>(str, headers);
        ResponseEntity<String> response =restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        LOGGER.info(response.getBody());
        praseXML(response.getBody());
        
        
        
        
        
        
        return response.getBody();
	}
	
	


	private static void praseXML(String body) throws ParserConfigurationException, SAXException, IOException {
		int idx = body.indexOf("dtd");
		if(idx > 0) {
		 body = body.substring(idx+5);
		}
		
		//LOGGER.info(body);
		
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource src = new InputSource();
		src.setCharacterStream(new StringReader(body));

		Document doc = builder.parse(src);
		String CCExpireDate = null;
		String profileProcStatus = null;
		LOGGER.info(doc.getElementsByTagName("CCExpireDate").getLength());
		if(doc.getElementsByTagName("CCExpireDate").getLength() != 0)
			CCExpireDate = doc.getElementsByTagName("CCExpireDate").item(0).getTextContent();
		if (doc.getElementsByTagName("ProfileProcStatus").getLength() != 0)
			profileProcStatus = doc.getElementsByTagName("ProfileProcStatus").item(0).getTextContent();
		
		LOGGER.info(CCExpireDate + " " + profileProcStatus);
		
		
	}
	
	
                //postForObject(url,request,String.class);
}
