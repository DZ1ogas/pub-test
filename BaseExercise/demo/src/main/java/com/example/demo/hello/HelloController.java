package com.example.demo.hello;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

// Since this is the controller, it is the place where we add our end-points
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloController {

	@Autowired
	private HelloService hs;
	
	
	/*	These are not implemented.
	@GetMapping(path="/civilians")
	public List<Civilian> getAllCivilians()  throws Exception{
		return hs.getAllCivilians();
	} 
	
	@PostMapping(path="/addCivilian")
	public void addCivilian(@RequestBody Civilian st) throws Exception {
		hs.addCivilian(st);
	}
	*/
}
