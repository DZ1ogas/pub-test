package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private String firstName;
	private String lastName;
	private int socialSec;
	// TODO connection to tables
	@OneToMany(mappedBy="lastName", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<Course>();
	
	public Doctor() {}
	
	public Doctor(String fn, String ln, int ss) {
		firstName = fn;
		lastName = ln;
		socialSec = ss;
	}
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public int getSocialSec() {return socialSec;}
	
	// TODO add timeslot method after implementation of timeslot
	public void addCourse(Course c) {
		courses.add(c);		
	}
}
