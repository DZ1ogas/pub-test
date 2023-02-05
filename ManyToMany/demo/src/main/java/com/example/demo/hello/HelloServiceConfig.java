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
		Student s1 = new Student("Apostolis",43,"Thessaloniki");
		s1.addCourse(new Course("SQA", 5));
		s1.addCourse(new Course("Mobile Development", 6));		
		hs.addStudent(s1);
		
		Student s2 = new Student("Alex",48,"Thessaloniki");
		s2.addCourse(new Course("OOP", 3));
		s2.addCourse(new Course("SE", 4));
		hs.addStudent(s2);
		
		Student s3 = new Student("Daniel",35,"Groningen");
		s3.addCourse(new Course("Patterns", 7));
		hs.addStudent(s3);
	}

}
