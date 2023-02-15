package com.example.demo.hello;

import java.util.*;
import java.time.*;
import javax.persistence.*;

@Entity
public class TimeSlot {
	
	//normally this would have a serializable id, we are doing this in a manual way
	
	@Id 
	private String timeSlotID;
	private LocalDateTime startAppointment;
	private LocalDateTime endAppointment;
	
	@ManyToOne
	@JoinColumn(name="doctor_lastName")
	private Doctor examiner;
	
	@ManyToOne
	@JoinColumn(name="vaccinationCenter_numID")
	private VaccinationCenter vacCenter;
	//private TreeSet<Integer> nextThirtyDays = new TreeSet<Integer>();

	/*	
	@ManyToMany(mappedBy="timeslots")
	*/
	//private Set<Doctor> doctors = new HashSet<Doctor>();
	
	@ManyToOne
	@JoinColumn(name="civilian_lastName")
	private Civilian examinee; 
	
	public TimeSlot() {
		
	}
	
	public TimeSlot(String id,String startTime, String endTime) {		//String must be "2015-02-20T06:30:00"
		timeSlotID = id;
		startAppointment = LocalDateTime.parse(startTime);
		endAppointment = LocalDateTime.parse(endTime);
		
	}
	//Setter for the 1Doctor to ManyTimeslots
	public void setDoctor(Doctor d) {
		examiner = d;
	}
	
	public void setCivilian(Civilian c) {
		examinee = c;
	}
	//Setter for the 1VaccinationCenter to ManyTimeslots
	public void setVC(VaccinationCenter vc) {
		vacCenter = vc;
	}
	
	public Doctor getDoctor() {return examiner;}
	public VaccinationCenter getVaccinationCenter() {return vacCenter;}
	public Civilian getCivilian() {return examinee;}
	
	public String getNumID() {return timeSlotID;}
	
	public int getTimeSlotDay() {
		return startAppointment.getDayOfYear();
	}
	/*
	// TreeSet that contains next 30 days (to give the opportunity to civilian to search for available time slots for a month
	public Set<Integer> getNextThirtyDays(TimeSlot t) {
		for (int i= t.getTimeSlotDay(); i <= t.getTimeSlotDay() + 30; i++) {
			nextThirtyDays.add(i);
		}
		return nextThirtyDays;
	}
	*/
	
}
