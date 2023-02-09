package com.example.demo.hello;

import java.util.*;
import javax.persistence.*;

@Entity
public class Course {
	@Id
	private String name;
	private int semester;
	
	@ManyToMany(mappedBy="courses")
	private Set<Civilian> students = new HashSet<Civilian>();
	
	@ManyToOne
	@JoinColumn(name="professor_name")
	private Doctor lecturer; 
	
	public Course() {
		
	}
	
	public Course(String n, int s) {
		name = n;
		semester =s;
	}
	
	public void setProfessor(Doctor p) {
		lecturer = p;
	}
	
	public String getName() {return name;}
	public int getSemester() {return semester;}
	public Doctor getProfessor() {return lecturer;}

	public void addStudent(Civilian s) {
		students.add(s);
	}
	
	
}
