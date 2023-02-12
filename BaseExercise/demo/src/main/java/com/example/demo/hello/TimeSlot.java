package com.example.demo.hello;

import java.util.*;
import java.time.*;
import javax.persistence.*;

@Entity
public class TimeSlot {
	@Id
	private LocalDateTime startAppointment;
	private LocalDateTime endAppointment;
	private Doctor examiner;
	private boolean available= true;
	
	@ManyToMany(mappedBy="timeslots")
	private Set<Doctor> doctor = new HashSet<Doctor>();
	
	@ManyToOne
	@JoinColumn(name="civilian_lastName")
	private Civilian examinee; 
	
	public TimeSlot() {
		
	}
	
	public TimeSlot(String startTime, String endTime) {		//String must be "2015-02-20T06:30:00"
		startAppointment = LocalDateTime.parse(startTime);
		endAppointment = LocalDateTime.parse(endTime);
		
	}
	
	public void setDoctor(Doctor d) {
		examiner = d;
	}
	
	//public String getName() {return name;}
	//public int getSemester() {return semester;}
	public Doctor getDoctor() {return examiner;}

	public void setCivilian(Civilian c) {
		examinee = c;
		available = false;
	}
	
	
	
}
