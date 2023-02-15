package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class VaccinationCenter {
	@Id
	private int numID;
	private String address;
	
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private Set<Vaccination> vSet = new HashSet<Vaccination>();

	// TODO connection to tables
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private Set<Doctor> dSet = new HashSet<Doctor>();
	
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private List<TimeSlot> availableTimeSlotsPerVc = new ArrayList<TimeSlot>();
	
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private Set<Civilian> cSet = new HashSet<Civilian>();
	
	public VaccinationCenter() {}
	
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
	
	// get all timeslots that a civilian can select for booking an appointment based on the vaccination center
	// it is a List since we might have some doctors with the same opened time slots
	public List<TimeSlot> getAvailableTimeSlotsPerVc() {
		for(Doctor d : dSet) {
			availableTimeSlotsPerVc.addAll(d.getAvailableTimeSlots());
		}
		return availableTimeSlotsPerVc;
	}
	
	// store all the vaccinations here, in order to get all the vaccinated civilians
	public HashSet<Vaccination> getAllVaccinations() {
		for(Doctor d : dSet) {
			vSet.add(d.v);
		}
		return (HashSet<Vaccination>) vSet;
	}
	
	// create a set with vaccinated civilians
	public HashSet<Civilian> getAllVaccinatedCivillians() {
		for(Vaccination v : vSet) {
			cSet.add(v.getVaccinatedCivilian());
		}
		return (HashSet<Civilian>) cSet;
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
