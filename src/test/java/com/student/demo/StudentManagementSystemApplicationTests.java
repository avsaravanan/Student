package com.student.demo;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.student.demo.controller.StudentManagementController;
import com.student.demo.service.StudentRepository;
import com.student.demo.bean.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentManagementSystemApplicationTests extends Assert{
	
	@Autowired
	private StudentManagementController smController;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private StudentRepository studentRepository;
	
	private Student student;
	
	RestTemplate template;
	
	private static final String BASE_URI = "http://localhost:8080/student/getstudent/11";
	

    @Before
    public void setup() {
    	template = new RestTemplate();
    	
    }
    
   
	@Test
	public void contextLoads()throws Exception {
		//assertThat(smController).isNotNull();
		assertNotNull(smController);
	}
	
	@Test
	public void test_for_getallstudents_getForObject(){
		
		Student stdnt = template.getForObject(BASE_URI, Student.class);
		
		System.out.println("###"+stdnt);
	}
	
	@Test
	public void exampleTest(){
		//ResponseEntity<Student> response = template.getForEntity(BASE_URI, Student.class);
		//assertEquals(response.getStatusCode().value(), 200);
		//String body = this.template.getForObject("http://localhost:8080/student/getstudent/11", String.class);
		//assertThat(body).contains("first_name");
		
	}
	
	
}
