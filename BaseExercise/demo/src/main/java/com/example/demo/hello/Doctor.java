package com.example.demo.hello;

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
	private List<TimeSlot> timeslots = new ArrayList<TimeSlot>();
	
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
	public void addTimeslot(TimeSlot c) {
		timeslots.add(c);		
	}
}
