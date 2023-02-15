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
	@Autowired
	private VaccinationCenterRepository vcRepository;
	@Autowired
	private TimeSlotRepository tsRepository;

	public void addCivilian(Civilian s) throws Exception {
		Optional<Civilian> byId = civilianRepository.findById(s.getlastName());
		if(!byId.isPresent())
			civilianRepository.save(s);
	}
	
	public void addDoctor(Doctor d) throws Exception {
		Optional<Doctor> byId = doctorRepository.findById(d.getlastName());
		if(!byId.isPresent())
			doctorRepository.save(d);
	}	
	
	public void addVC(VaccinationCenter vc) throws Exception {
		Optional<VaccinationCenter> byId = vcRepository.findById(vc.getNumID());
		if(!byId.isPresent())
			vcRepository.save(vc);
	}
	
	public void addTimeSlot(TimeSlot ts) throws Exception {
		Optional<TimeSlot> byId = tsRepository.findById(ts.getNumID());
		if(!byId.isPresent())
			tsRepository.save(ts);
	}

	public List<Civilian> getAllCivilians() throws Exception {
		return civilianRepository.findAll();
	}

}
