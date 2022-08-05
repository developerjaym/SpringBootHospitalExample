package com.example.hospital;

import com.example.hospital.model.Hospital;
import com.example.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Component
	public class ApplicationStartupRunner implements CommandLineRunner {

		@Autowired
		private HospitalService hospitalService;

		@Override
		public void run(String... args) {
			// Part 1 - Let's look at the models
			// Part 1b - Let's create, read, update, delete, and then read again to prove we deleted
			hospitalService.createHospital("St. Jay's");
			Hospital hospital = hospitalService.getHospital(1L);
			Hospital hospitalWithRightName = hospitalService.updateName("Dr. Jay's");
			System.out.println("------------------------------------------------------------");
			System.out.println(hospital);
			System.out.println("------------------------------------------------------------");
//			hospitalService.deleteHospital(1L);
//			System.out.println(hospitalService.getHospital(1L)); // This line throws an exception because that
//			hospital was deleted

			// Part 2 - Let's do some custom queries
			// Find by hospital name?

			// Part 3 - Really custom queries
			// Let's create a couple Hospitals with addresses
			// And then let's do a really custom query to get a List of Hospitals in some region
			// What if we want a list of hospitals with a name like something (ignoring case)?
			// What if we want a Stream of hopsitals with a name like something (ignoring case)?

			// Part 4 - Some other good stuff to know
			// What if we don't want multiple hospitals to have the same name?


		}
	}
}
