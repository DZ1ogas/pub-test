package com.example.demo.hello;

import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;

@Entity
public class Civilian {
	
	private String firstName;
	@Id
	private String lastName;
	private String socialSec;
	private String afm;
	private String email;
	private int counter = 2;
	private Appointment appo;

	// TODO connection to other tables  1 to 1
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="civilian_timeslot", 
			   joinColumns = @JoinColumn(name="civilian_lastName"),
			   inverseJoinColumns = @JoinColumn(name="timeslots"))
	
	private Set<TimeSlot> timeslots = new HashSet<TimeSlot>();
	
	@ManyToOne
	@JoinColumn(name="Vaccination_Center_name")
	private VaccinationCenter vc; 
	

	//default constructor
	public Civilian(){}

	public Civilian(String fn, String ln, String ss, String a, String em) {
		firstName = fn;
		lastName = ln;
		socialSec = ss;
		afm = a;
		email = em;
	}
	
	
//	public void addTimeslot(TimeSlot t) {
//		timeslots.add(t);
//		t.setCivilian(this);
//	}
	
	
	
	// Create an Appointment based on the availability of a vaccination center
	// edw sigoura tha xreiastei logiki me JS gia ta buttons
	public void createAppointment(TimeSlot t){
		boolean createAppointmentButton = false;
		boolean changeAppointmentButton = false;
			if(t.getNextThirtyDays(t).contains(t.getTimeSlotDay()) && vc.getAvailableTimeSlotsPerVc().contains(t)) {
				while (counter > 0) {
				if(createAppointmentButton) {
					appo = new Appointment(this, t);
					counter -= 3;
				} else if(changeAppointmentButton) {
					appo = null;
					counter--;
					System.out.println("You can reschedule your appointment for " + counter + " more times");
			}

		}
				System.out.println("Your appointment is created");

		} else {
			System.out.println("Enter another timeslot");
		}
		
		
	}
	

	// Civilian searches on the platform to check his/her vaccination status
	public String getStatus(String dateInit) {
		if (vc.isVaccinated(this)  &&  LocalDateTime.parse(dateInit).plusMonths(6).getDayOfYear() > LocalDateTime.now().getDayOfYear()) {
			return "You are vaccinated for " + (LocalDateTime.parse(dateInit).plusMonths(6).getDayOfYear() - LocalDateTime.now().getDayOfYear()) + " more days";
		}
		else {
			return "You should get vaccinated"; 
		}
	}
	
	
	public String getfirstName() {return firstName;}
	public String getlastName() {return lastName;}
	public String getSocialSec() {return socialSec;}
	public String getAfm() {return afm;}
	public String getEmail() {return email;}
	public void addTimeslot(TimeSlot t) {
		timeslots.add(t);
	}
	// TODO fix should be rantevou
	public Set<TimeSlot> getTimeslots() {return timeslots;}
	
}
