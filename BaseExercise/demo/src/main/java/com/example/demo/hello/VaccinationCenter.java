package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class VaccinationCenter {
	@Id
	private int numID;
	private String address;

	// TODO connection to tables
	@OneToMany(mappedBy="numID", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private List<TimeSlot> courses = new ArrayList<TimeSlot>();
	
	public VaccinationCenter() {}
	
	public VaccinationCenter(int num, String ad) {
		numID = num;
		address = ad;
	}
	
	public int getNumID() {return numID;}
	public String getAddress() {return address;}
	
	// TODO add timeslot method after implementation of timeslot
	public void addCourse(TimeSlot c) {
		courses.add(c);		
	}
}
