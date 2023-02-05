package com.example.demo.hello;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	ArrayList<Student> sList = new ArrayList<Student>();
	
	public void addStudent(String name,int age, String location) {
		sList.add(new Student(name,age,location));
	}
	
	public ArrayList<Student> getStudents(){
		return sList;
	}
}
