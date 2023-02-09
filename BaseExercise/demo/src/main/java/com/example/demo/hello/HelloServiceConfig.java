package com.example.demo.hello;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
public class HelloServiceConfig implements CommandLineRunner {
	
	@Autowired
	private HelloService hs;
	
	@Override
	public void run(String... args) throws Exception {
		Doctor p1 = new Doctor("Apostolis", "Associate Prof");
		hs.addDoctor(p1);
		Doctor p2 = new Doctor("Daniel", "Assistant Prof");
		hs.addDoctor(p2);
		Doctor p3 = new Doctor("Alex", "Prof");
		hs.addDoctor(p3);
		
		Course c3 = new Course("OOP", 3);
		c3.setProfessor(p3);
		Course c4 = new Course("SE", 4);
		c4.setProfessor(p3);
		Course c1 = new Course("SQA", 5);
		c1.setProfessor(p1);
		Course c2 = new Course("Mobile", 6);
		c2.setProfessor(p1);
		Course c5 = new Course("Patterns", 7);
		c5.setProfessor(p2);

		
		Civilian s1 = new Civilian("Nikos",28,"Thessaloniki");
		s1.addCourse(c2);
		s1.addCourse(c3);
		hs.addCivilian(s1);
		
		Civilian s2 = new Civilian("Elvira",35,"Thessaloniki");
		s2.addCourse(c1);
		s2.addCourse(c4);
		hs.addCivilian(s2);
		
		Civilian s3 = new Civilian("Sofia",36,"Groningen");
		s3.addCourse(c5);
		hs.addCivilian(s3);
	}

}
