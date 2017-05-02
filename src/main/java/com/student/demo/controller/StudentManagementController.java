package com.student.demo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.demo.bean.*;
import com.student.demo.service.*;

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
	@ResponseBody
	public String createStudent(Student student) {
		LOG.info("### Student First name: "+student.getFirst_name());
		studentService.createStudent(student);

		return "Confirm";
	}
	
	@RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
	@ResponseBody
	public String updateStudent(Student student) {
		
		studentService.updateStudent(student);

		return "Confirm";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/deletestudent/{id}",method = RequestMethod.GET)
	public @ResponseBody String deleteStudent(@PathVariable Integer id) {
		LOG.info("### executing deleteStudent..");
		 studentService.deleteStudent(id);
		 return "Deleted";
	}

}
