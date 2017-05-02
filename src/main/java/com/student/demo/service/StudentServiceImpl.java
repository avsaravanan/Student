package com.student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.service.StudentRepository;
import com.student.demo.bean.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public void setStudentRepository(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
		
	}
	
	@Override
	public Iterable<Student> listStudents() {
		return studentRepository.findAll();
		
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(Integer id) {
		return studentRepository.findOne(id);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.delete(id);
		
	}

}
