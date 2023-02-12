package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Civilian {
	@Id
	private String firstName;
	private String lastName;
	private String socialSec;
	private String afm;
	private String email;
	// TODO connection to other tables  1 to 1
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="civilian_timeslot", 
			   joinColumns = @JoinColumn(name="civilian_lastName"),
			   inverseJoinColumns = @JoinColumn(name="timeslots"))
	// TODO fix should be rantevou
	private Set<TimeSlot> timeslots = new HashSet<TimeSlot>();

	//default constructor
	public Civilian(){}

	public Civilian(String fn, String ln, String ss, String a, String em) {
		firstName = fn;
		lastName = ln;
		socialSec = ss;
		afm = a;
		email = em;
	}
	
	public void addTimeslot(TimeSlot t) {
		timeslots.add(t);
		t.addCivilian(this);
	}
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public String getSocialSec() {return socialSec;}
	public String getAfm() {return afm;}
	public String getEmail() {return email;}
	// TODO fix should be rantevou
	public Set<TimeSlot> getTimeslots() {return timeslots;}
	
}
