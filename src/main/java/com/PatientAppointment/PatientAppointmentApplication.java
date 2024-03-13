package com.PatientAppointment;

import com.PatientAppointment.services.VaccineScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class PatientAppointmentApplication implements CommandLineRunner {

	@Autowired
	private  VaccineScheduler vaccineScheduler;

	public static void main(String[] args) {

		SpringApplication.run(PatientAppointmentApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		vaccineScheduler.addAppointment("1", LocalDateTime.of(2023, 10, 10, 5, 30));
		vaccineScheduler.addAppointment("2", LocalDateTime.of(2023, 10, 10, 6, 30));
		vaccineScheduler.addAppointment("1", LocalDateTime.of(2023, 10, 10, 6, 00));
		vaccineScheduler.addAppointment("1", LocalDateTime.of(2023, 10, 11, 6, 00));
		System.out.println(vaccineScheduler.getAvailableAppointments(LocalDate.of(2023, 10, 10)));

		vaccineScheduler.scheduleAppointment("1", "1", LocalDateTime.of(2023, 10, 10, 5, 30));
		System.out.println(vaccineScheduler.getAvailableAppointments(LocalDate.of(2023, 10, 10)));

//		vaccineScheduler.removeAppointment("2", LocalDateTime.of(2023, 10, 10, 6, 30));
//		System.out.println(vaccineScheduler.getAvailableAppointments(LocalDate.of(2023, 10, 10)));

		vaccineScheduler.scheduleAppointment("2", "2", LocalDateTime.of(2023, 10, 10, 6, 30));
		System.out.println(vaccineScheduler.getAvailableAppointments(LocalDate.of(2023, 10, 10)));

		vaccineScheduler.cancelAppointment("2");
		System.out.println(vaccineScheduler.getAvailableAppointments(LocalDate.of(2023, 10, 10)));


	}
}
