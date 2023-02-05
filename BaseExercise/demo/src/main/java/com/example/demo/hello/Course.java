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
	
	@ManyToOne
	@JoinColumn(name="professor_name")
	private Professor lecturer; 
	
	public Course() {
		
	}
	
	public Course(String n, int s) {
		name = n;
		semester =s;
	}
	
	public void setProfessor(Professor p) {
		lecturer = p;
	}
	
	public String getName() {return name;}
	public int getSemester() {return semester;}
	public Professor getProfessor() {return lecturer;}

	public void addStudent(Student s) {
		students.add(s);
	}
	
	
}
