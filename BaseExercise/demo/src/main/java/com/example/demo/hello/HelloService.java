package com.example.demo.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class HelloService {

	@Autowired
	private CivilianRepository studentRepository;
	@Autowired
	private DoctorRepository profRepository;

	public void addStudent(Civilian s) throws Exception {
		Optional<Civilian> byId = studentRepository.findById(s.getfirstName());
		if(!byId.isPresent())
			studentRepository.save(s);
	}
	
	public void addProfessor(Doctor p) throws Exception {
		Optional<Doctor> byId = profRepository.findById(p.getName());
		if(!byId.isPresent())
			profRepository.save(p);
	}	

	public List<Civilian> getAllStudents() throws Exception {
		return studentRepository.findAll();
	}

}
