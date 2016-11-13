package com.ir.learning.poc.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ir.learning.poc.domainmodel.Student;
import com.ir.learning.poc.domainmodel.Subject;
import com.ir.learning.poc.domainmodel.Teacher;

public class JsonPoc {
	
	
	public static void main(String[] args) throws IOException {
		
		//final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";
		ObjectMapper om = new ObjectMapper();
		Subject subject = new Subject("Physics", "XII", 34);
		Student student = new Student("Ibrahim", 30, "Address", 20000.00, 1234567, subject);
		Teacher teacher = new Teacher("Ibu", "Physics", 32, student);
		String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(teacher);
		System.out.println("jsonString: " + jsonString);
		
		Teacher tchr = om.readValue(jsonString, Teacher.class);
		
		//Student std = om.convertValue(jsonString, Student.class); //not working
		
		JSONObject jsonObject = new JSONObject(jsonString);
		
		System.out.println("Name: " + tchr.getName());
		System.out.println("Name from JSONObject: " + jsonObject.getString("name"));
		//System.out.println("Name: " + std.getName());
		//URI.parse(BASE_URL).
		
		JSONObject jsonObjectStudent = jsonObject.getJSONObject("student");
		//jsonObjectStudent.toJSONArray(arg0);
		//Teacher tchr1 =  (Teacher)JSONObject.stringToValue(jsonString); // not working
		//System.out.println(tchr1.getAge());
		
		System.out.println(jsonObjectStudent.toString());
		
		Student student1 = om.readValue(jsonObjectStudent.toString(), Student.class);
		
		System.out.println("Name: " + student1.getName());
		
		JsonPoc jp = new JsonPoc();
		
		Student std = jp.getData(Student.class);
		System.out.println(std.getName());
		
		
		
	}
	
	public <T> T getData(Class<T> responseType) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		Subject subject = new Subject("Physics", "XII", 34);
		Student student = new Student("Rashid", 32, "Address", 20000.00, 1234567, subject);
		Teacher teacher = new Teacher("Ibu", "Physics", 32, student);
		String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(teacher);
		System.out.println(jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);
		Iterator<String> keys = jsonObject.keys();
		while(keys.hasNext()) {
			String str = keys.next();
			System.out.println(str);
			System.out.println(jsonObject.get(str));
		}
		
		Set<String> keySet = jsonObject.keySet();
		for(String key : keySet) {
			System.out.println(key);
			System.out.println(jsonObject.get(key));
		}
		
		JSONObject jsonObjectStudent = jsonObject.getJSONObject("student");
		
		T t = (T)om.readValue(jsonObjectStudent.toString(), responseType);
		return t;
	}

}
