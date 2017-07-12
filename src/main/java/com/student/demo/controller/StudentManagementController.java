package com.student.demo.controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.demo.bean.*;
import com.student.demo.service.*;
import com.student.demo.util.*;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(value = "/student")
public class StudentManagementController {
	private static final Logger LOG = LoggerFactory
			.getLogger(StudentManagementController.class);
	@Autowired
	private StudentService studentService;
	
	@Autowired
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@RequestMapping("/welcome")
	public String indexPage(ModelAndView model) {
		return "index";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String listStudents(@ModelAttribute("student") Student student, ModelMap model) {
		LOG.info("### executing listStudents..");
		model.addAttribute("student",  studentService.listStudents());
		return "ListStudents";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/getstudents", method = RequestMethod.GET)
	public @ResponseBody Iterable<Student> getAllStudents() {
		StudentUtil sutil = new StudentUtil();
		List<State> slist = sutil.getStates();
		Collections.sort(slist,	new State());
		Iterator<State> iter = slist.iterator();
		if(!slist.isEmpty()){
			for(int i=0;i<slist.size();i++){
				System.out.println("### :"+ iter.next().getStateName());
			}
		}
		
		LOG.info("### executing getAllStudents..");
		return studentService.listStudents();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/getstudent/{id}",method = RequestMethod.GET)
	public @ResponseBody Student getStudent(@PathVariable Integer id) {
		LOG.info("### executing getStudent..");
		return studentService.getStudent(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/editstudent/{id}",method = RequestMethod.GET)
	public String editStudent(@ModelAttribute("student") Student student, ModelMap model, @PathVariable Integer id) {
		LOG.info("### executing editStudent..");
		model.addAttribute("student",  studentService.getStudent(id));
		return "UpdateStudent";
	}
	
	
	@RequestMapping("/addstudent")
	public String showStudent(
			@ModelAttribute("student") Student student, ModelMap model) {
		model.addAttribute("student", student);
		return "NewStudent";
	}
	
	
	@RequestMapping(value = "/createstudent", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		LOG.info("### Student First name: "+student.getFirst_name());
		studentService.createStudent(student);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@Modifying
	@RequestMapping(value = "/updatestudent", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		LOG.info("### Student First name: "+student.getId()+" "+student.getFirst_name() +" "+student.getLast_name()+" "+student.getEmail());
		//student.setId(student.getId());
		//student.setFirst_name(student.getFirst_name());
		//student.setLast_name(student.getLast_name());
		//student.setEmail(student.getEmail());
		studentService.updateStudent(student);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/deletestudent/{id}",method = RequestMethod.GET)
	public @ResponseBody String deleteStudent(@PathVariable Integer id) {
		LOG.info("### executing deleteStudent..");
		 studentService.deleteStudent(id);
		 return "Deleted";
	}

}
