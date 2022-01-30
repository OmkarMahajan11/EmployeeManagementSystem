package com.example.EMS;

import com.example.EMS.model.Employee;
import com.example.EMS.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// Employee employee = new Employee();
		// employee.setFirstName("Boman");
		// employee.setLastName("Irani");
		// employee.setEmailId("boman@gmail.com");
		// employeeRepository.save(employee);

		// Employee employee1 = new Employee();
		// employee1.setFirstName("John");
		// employee1.setLastName("Cena");
		// employee1.setEmailId("cena@gmail.com");
		// employeeRepository.save(employee1);
	}
}
