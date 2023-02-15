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
	private TreeSet<Integer> nextThirtyDays = new TreeSet<Integer>();

	
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

//	public void setCivilian(Civilian c) {
//		examinee = c;
//		available = false;
//	}
	
	
	
	public int getTimeSlotDay() {
		return startAppointment.getDayOfYear();
	}
	
	// TreeSet that contains next 30 days (to give the opportunity to civilian to search for available time slots for a month
	public Set<Integer> getNextThirtyDays(TimeSlot t) {
		for (int i= t.getTimeSlotDay(); i <= t.getTimeSlotDay() + 30; i++) {
			nextThirtyDays.add(i);
		}
		return nextThirtyDays;
	}
	


	
}
