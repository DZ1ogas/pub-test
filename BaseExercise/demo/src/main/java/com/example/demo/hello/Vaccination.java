package com.example.demo.hello;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Vaccination {
	
	private Civilian c;
	private Doctor d;
	private LocalDateTime dateInit;
	private LocalDateTime dateFinal;
	
	public Vaccination(Civilian c, Doctor d, String dateInit, String dateFinal) {
		
		this.c = c;
		this.d = d;
		this.dateInit = LocalDateTime.parse(dateInit);
		this.dateFinal = LocalDateTime.parse(dateInit).plusMonths(6); 
	}
	
	public LocalDateTime getExpirationDate() {
		return dateFinal;
	}
	
	public Civilian getVaccinatedCivilian() {
		return c;
	}
	

	

	
	

}
