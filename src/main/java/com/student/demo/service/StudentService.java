package com.student.demo.service;

import com.student.demo.bean.Student;

public interface StudentService {
	Iterable<Student> listStudents();
	Student createStudent(Student student);
	Student getStudent(Integer id);
	Student updateStudent(Student student);
	void deleteStudent(Integer id);
}
