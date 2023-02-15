package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class VaccinationCenter {
	
	@Id
	private int numID;
	private String address;
	/*	Not required yet
	@OneToMany(mappedBy="timeSlotID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	*/
	private Set<Vaccination> vSet = new HashSet<Vaccination>();

	/*	Not required yet
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	*/
	private Set<Doctor> dSet = new HashSet<Doctor>();
	
	@OneToMany(mappedBy="timeSlotID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private Set<TimeSlot> timeslots = new HashSet<TimeSlot>();
	
	/*	Probably not required yet
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	*/
	private Set<Civilian> cSet = new HashSet<Civilian>();
	
	//	Default Constructor
	public VaccinationCenter() {}
	
	//	Basic Constructor
	public VaccinationCenter(int num, String ad) {
		numID = num;
		address = ad;
	}
	
	public int getNumID() {return numID;}
	public String getAddress() {return address;}
	
	// TODO add timeslot method after implementation of timeslot
	// insert doctors from the DataBase??
	public void addDoctor(Doctor d) {
		dSet.add(d);		
	}
	
	public void addTimeslot(TimeSlot t) {
		timeslots.add(t);
	}
	
	// get all timeslots that a civilian can select for booking an appointment based on the vaccination center
	// it is a List since we might have some doctors with the same opened time slots
	public Set<TimeSlot> getAvailableTimeSlotsPerVc() {
		for(Doctor d : dSet) {
			timeslots.addAll(d.getAvailableTimeSlots());
		}
		return timeslots;
	}
	
	// store all the vaccinations here, in order to get all the vaccinated civilians
	public Set<Vaccination> getAllVaccinations() {
		for(Doctor d : dSet) {
			vSet.add(d.v);
		}
		return (Set<Vaccination>) vSet;
	}
	
	// create a set with vaccinated civilians
	public Set<Civilian> getAllVaccinatedCivillians() {
		for(Vaccination v : vSet) {
			cSet.add(v.getVaccinatedCivilian());
		}
		return (Set<Civilian>) cSet;
	}
	
	// define if a civilian is vaccinated
	public boolean isVaccinated(Civilian c) {
		if(cSet.contains(c)) {
			return true;
		} else {
			return false;
		}
	}

}
