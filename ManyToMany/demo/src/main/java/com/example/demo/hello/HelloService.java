package com.example.demo.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class HelloService {

	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(Student s) throws Exception {
		Optional<Student> byId = studentRepository.findById(s.getName());
		if(!byId.isPresent())
			studentRepository.save(s);
	}

	public List<Student> getAllStudents() throws Exception {
		return studentRepository.findAll();
	}

}
