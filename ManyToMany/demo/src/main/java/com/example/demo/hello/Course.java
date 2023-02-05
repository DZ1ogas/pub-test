package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Course {
	@Id
	private String name;
	private int semester;
	
	@ManyToMany(mappedBy="courses")
	private Set<Student> students = new HashSet<Student>();
	
	public Course() {
		
	}
	
	public Course(String n, int s) {
		name = n;
		semester =s;
	}
	
	public String getName() {return name;}
	public int getSemester() {return semester;}
	
	
}
