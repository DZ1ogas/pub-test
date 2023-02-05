package com.example.demo.hello;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Since this is the controller, it is the place where we add our end-points
@RestController
public class HelloController {

	// Defines that this method is called with GET Request
	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}
	
	@Autowired
	private HelloService hs;
	
	// With the path, it changes from root to a specific path: http://localhost:8080/hello
	// else it would respond to http://localhost:8080
	@GetMapping(path="/list")
	public List<String> printList() {
		List<String> sList = new ArrayList<String>();
		sList.add("Hello World");
		sList.add("My name is Apostolis");
		sList.add("My surname is Ampatzoglou");
		return sList;
	}
	
	// Call as follows:
	// http://localhost:8080/askName/Nikos
	@GetMapping(path="/askName/{name}")
	public String askName(@PathVariable(value="name") String name) {
		return "Hello " + name;
	}

	// Call as follows:
	// http://localhost:8080/student?name=Gio&age=24&location=Salonica
	@GetMapping(path="/addStudent")
	public void printStudent(@RequestParam(value="name") String name,
			@RequestParam(value="age") int age,
			@RequestParam(value="location") String location) {
		
		hs.addStudent(name, age, location);
		
	} 
	@GetMapping(path="getStudents")
	public List<Student> getAllStudents(){
		return hs.getStudents();
	}
}
