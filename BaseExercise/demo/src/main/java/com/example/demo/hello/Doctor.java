package com.example.demo.hello;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private String firstName;
	private String lastName;
	private String socialSec;

	// TODO connection to tables
	
	@OneToMany(mappedBy="lastName", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private HashSet<TimeSlot> timeslots = new HashSet<TimeSlot>();
	private HashSet<TimeSlot> availableTimeSlots = new HashSet<TimeSlot>();
	
	@OneToMany
	(mappedBy="lastName",
			cascade= CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Set<Appointment> appos = new HashSet<Appointment>();
	
	Vaccination v;
	
	@OneToMany
	(mappedBy="lastName",
			cascade= CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Set<Vaccination> vSet = new HashSet<Vaccination>();

	
	public Doctor() {}
	
	public Doctor(String fn, String ln, String ss) {
		firstName = fn;
		lastName = ln;
		socialSec = ss;
	}
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public String getSocialSec() {return socialSec;}
	
	// TODO add timeslot method after implementation of timeslot
	public void addTimeslot(TimeSlot t) {
		timeslots.add(t);		
	}
	
	// add an appointment to the appointment list
	public void addAppointment(Appointment appo) {
		appos.add(appo);
	}
	
	
	// get the appointments of the day
	public Set<Appointment> getAppointmentsOfTheDay(int day) {
		for(Appointment appo : appos) {
			if (day == appo.getAppointmentDay())
				appos.add(appo);			
		}
		
		return appos;
		
	}
	
//	public boolean isBooked(t) {
//		for(Appointment appo : appos) {
////			if(!timeslots.contains(appo.getTimeSlot())) {
////				isBooked = false;
////				
////			}
//		}
//		return isBooked;
//	}
	
	// get the timeslots that are not marked as appointments
	public HashSet<TimeSlot> getAvailableTimeSlots() {
		for(TimeSlot t : timeslots) {
			if(!appos.contains(t)) {
				availableTimeSlots.add(t);
			}
		}
		return availableTimeSlots;
	}
	
	public void setNewVaccination(Civilian c, String dateInit) {
		// if((dateFinal.getMonth().getValue() - dateInit.getMonth().getValue() == 6) || (dateFinal.getMonth().getValue() - dateInit.getMonth().getValue() == -6)) {
		
		v = new Vaccination(c, this, dateInit, getVaccinationExpirationDate(dateInit));
		// String timeSpaceOfEffect = dateInit + " - " + getVaccinationExpiredDate(dateInit);
		
	}
	
	
	
	// Get Expiration date
	public String getVaccinationExpirationDate(String dateInit) {
		return v.getExpirationDate().toString();
	}
	

	


}
	
	
