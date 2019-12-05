package com.ir.learning.poc.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ir.learning.poc.domainmodel.Student;
import com.ir.learning.poc.domainmodel.Subject;
import com.ir.learning.poc.domainmodel.Teacher;

public class JsonPoc {
	
	private static final Logger LOGGER = Logger.getLogger(JsonPoc.class);
	
	public static void main(String[] args) throws IOException {
		
		//final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";
		ObjectMapper om = new ObjectMapper();
		Subject subject = new Subject("Physics", "XII", 34);
		Student student = new Student("Ibrahim", 30, "Address", 20000.00, 1234567, subject);
		Teacher teacher = new Teacher("Ibu", "Physics", 32, student);
		String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(teacher);
		LOGGER.info("jsonString: " + jsonString);
		
		Teacher tchr = om.readValue(jsonString, Teacher.class);
		
		//Student std = om.convertValue(jsonString, Student.class); //not working
		
		JSONObject jsonObject = new JSONObject(jsonString);
		
		LOGGER.info("Name: " + tchr.getName());
		LOGGER.info("Name from JSONObject: " + jsonObject.getString("name"));
		//LOGGER.info("Name: " + std.getName());
		//URI.parse(BASE_URL).
		
		JSONObject jsonObjectStudent = jsonObject.getJSONObject("student");
		//jsonObjectStudent.toJSONArray(arg0);
		//Teacher tchr1 =  (Teacher)JSONObject.stringToValue(jsonString); // not working
		//LOGGER.info(tchr1.getAge());
		
		LOGGER.info(jsonObjectStudent.toString());
		
		Student student1 = om.readValue(jsonObjectStudent.toString(), Student.class);
		
		LOGGER.info("Name: " + student1.getName());
		
		JsonPoc jp = new JsonPoc();
		
		Student std = jp.getData(Student.class);
		LOGGER.info(std.getName());
		
		
		
	}
	
	public <T> T getData(Class<T> responseType) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		Subject subject = new Subject("Physics", "XII", 34);
		Student student = new Student("Rashid", 32, "Address", 20000.00, 1234567, subject);
		Teacher teacher = new Teacher("Ibu", "Physics", 32, student);
		String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(teacher);
		LOGGER.info(jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);
		Iterator<String> keys = jsonObject.keys();
		while(keys.hasNext()) {
			String str = keys.next();
			LOGGER.info(str);
			LOGGER.info(jsonObject.get(str));
		}
		
		Set<String> keySet = jsonObject.keySet();
		for(String key : keySet) {
			LOGGER.info(key);
			LOGGER.info(jsonObject.get(key));
		}
		
		JSONObject jsonObjectStudent = jsonObject.getJSONObject("student");
		
		T t = (T)om.readValue(jsonObjectStudent.toString(), responseType);
		return t;
	}

}
