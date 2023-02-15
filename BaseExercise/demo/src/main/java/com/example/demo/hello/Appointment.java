package com.example.demo.hello;

public class Appointment {
	
	Civilian c;
	TimeSlot t;
	
	public Appointment(Civilian c, TimeSlot t) {
		this.c = c;
		this.t = t;
	}
	
	
	public TimeSlot getTimeSlot() {
		return t;
	}
	
	public int getAppointmentDay() {
		return t.getTimeSlotDay();
	}

}
