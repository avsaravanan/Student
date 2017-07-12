package com.student.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.student.demo.bean.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
