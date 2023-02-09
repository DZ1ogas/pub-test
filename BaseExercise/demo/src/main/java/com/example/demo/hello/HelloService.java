package com.example.demo.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class HelloService {

	@Autowired
	private CivilianRepository civilianRepository;
	@Autowired
	private DoctorRepository doctorRepository;

	public void addCivilian(Civilian s) throws Exception {
		Optional<Civilian> byId = civilianRepository.findById(s.getlastName());
		if(!byId.isPresent())
			civilianRepository.save(s);
	}
	
	public void addDoctor(Doctor p) throws Exception {
		Optional<Doctor> byId = doctorRepository.findById(p.getlastName());
		if(!byId.isPresent())
			doctorRepository.save(p);
	}	

	public List<Civilian> getAllCivilians() throws Exception {
		return civilianRepository.findAll();
	}

}
