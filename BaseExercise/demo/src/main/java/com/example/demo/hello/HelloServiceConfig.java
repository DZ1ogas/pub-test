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
		
		/*	
		 * 	Hypotheses:
		 * 	Doctors have unique surnames, this could have been done by socialSec
		 * 	Doctors input a unique id as an ID for the timeslot, should be serializable
		 */
		
		Doctor d1 = new Doctor("Dimitris", "ZG", "30029300183");
		hs.addDoctor(d1);
		Doctor d2 = new Doctor("Dimitris", "KP", "15129300184");
		hs.addDoctor(d2);
		VaccinationCenter vc1 = new VaccinationCenter(41, "31st Street");
		hs.addVC(vc1);
		Civilian c1 = new Civilian("Xrhstos", "Lemonis", "15110000320", "12310815", "lemo@randomail.com");
		hs.addCivilian(c1);
		Civilian c2 = new Civilian("Nikos", "Xrhstou", "15110000312", "123180321", "nikosx@randomail.com");
		hs.addCivilian(c2);
		TimeSlot ts1 = new TimeSlot(1,"2022-02-20T06:30:00", "2022-02-20T07:00:00");
		ts1.setDoctor(d1);
		ts1.setVC(vc1);
		ts1.setCivilian(c1);
		hs.addTimeSlot(ts1);
		TimeSlot ts2 = new TimeSlot(2,"2022-02-20T07:00:00", "2022-02-20T07:30:00");
		ts2.setDoctor(d1);
		ts2.setVC(vc1);
		hs.addTimeSlot(ts2);
		TimeSlot ts3 = new TimeSlot(3,"2022-02-20T07:00:00", "2022-02-20T07:30:00");
		ts3.setDoctor(d2);
		ts3.setVC(vc1);
		ts3.setCivilian(c2);
		hs.addTimeSlot(ts3);
	}

}
