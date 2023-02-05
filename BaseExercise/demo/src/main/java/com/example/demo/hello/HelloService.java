package com.example.demo.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class HelloService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ProfessorRepository profRepository;

	public void addStudent(Student s) throws Exception {
		Optional<Student> byId = studentRepository.findById(s.getName());
		if(!byId.isPresent())
			studentRepository.save(s);
	}
	
	public void addProfessor(Professor p) throws Exception {
		Optional<Professor> byId = profRepository.findById(p.getName());
		if(!byId.isPresent())
			profRepository.save(p);
	}	

	public List<Student> getAllStudents() throws Exception {
		return studentRepository.findAll();
	}

}
