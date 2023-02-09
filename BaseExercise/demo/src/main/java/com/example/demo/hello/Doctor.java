package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	private String name;
	private String rank;
	
	@OneToMany(mappedBy="name", 
		       cascade= CascadeType.ALL,
		       fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<Course>();
	
	public Doctor() {}
	
	public Doctor(String n, String r) {
		name = n;
		rank = r;
	}
	
	public String getName() {return name;}
	public String getRank() {return rank;}

	public void addCourse(Course c) {
		courses.add(c);		
	}
}
