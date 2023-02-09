package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Civilian {
	@Id
	private String firstName;
	private String lastName;
	private int socialSec;
	private int afm;
	private String email;
	// TODO connection to other tables
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="student_courses", 
			   joinColumns = @JoinColumn(name="student_name"),
			   inverseJoinColumns = @JoinColumn(name="course_name"))
	// TODO fix should be rantevou
	private Set<Course> courses = new HashSet<Course>();

	//default constructor
	public Civilian(){}

	public Civilian(String fn, String ln, int ss, int a, String em) {
		firstName = fn;
		lastName = ln;
		socialSec = ss;
		afm = a;
		email = em;
	}

	public void addCourse(Course c) {
		courses.add(c);
		c.addStudent(this);
	}
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public int getSocialSec() {return socialSec;}
	public int getAfm() {return afm;}
	public String getEmail() {return email;}
	// TODO fix should be rantevou
	public Set<Course> getCourses() {return courses;}
	
}