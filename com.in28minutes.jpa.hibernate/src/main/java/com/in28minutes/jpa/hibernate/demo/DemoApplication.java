package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.*;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		long st, en;
		double el;

		//studentRepository.saveStudentWithPassport();
		//repository.playWithEntityManager();
		//courseRepository.addHardcodedReviewsForCourse();
		//List<Review> reviews = new ArrayList<>();

		//reviews.add(new Review("5", "Great Hands-on Stuff."));
		//reviews.add(new Review("5", "Hatsoff."));

		//courseRepository.addReviewsForCourse(10003L, reviews );

		/**
		st = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			employeeRepository.insert(new PartTimeEmployee("Jill" + i, new BigDecimal("50")));
			employeeRepository.insert(new FullTimeEmployee("Jack" + i, new BigDecimal("10000")));
			employeeRepository.insert(new AEmployee("Poll" + i, "TestValue"));
		}
		en = System.nanoTime();
		el = (en - st)  / 1000000000.0;
		System.out.println("Insert execute time " + el + " sec");

		st = System.nanoTime();
		List<Employee> employees = employeeRepository.retrieveAllEmployees();
		en = System.nanoTime();
		el = (en - st)  / 1000000000.0;
		System.out.println("Select execute time " + el + " sec");
*/


		//logger.info("All Employees -> {}", employees);

//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

//		logger.info("Full Time Employees -> {}",
//				employeeRepository.retrieveAllFullTimeEmployees());

//		logger.info("Part Time Employees -> {}",
//				employeeRepository.retrieveAllPartTimeEmployees());
	}
}
