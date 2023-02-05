package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Student {
	@Id
	private String name;
	private int age;
	private String location;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="student_courses", 
			   joinColumns = @JoinColumn(name="student_name"),
			   inverseJoinColumns = @JoinColumn(name="course_name"))
	private Set<Course> courses = new HashSet<Course>();

	//default constructor
	public Student(){}

	public Student(String n, int a, String l) {
		name = n;
		age = a;
		location =l;
	}

	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public String getLocation() {return location;}
	public Set<Course> getCourses() {return courses;}
	
}
