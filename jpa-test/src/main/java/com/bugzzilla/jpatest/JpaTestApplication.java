package com.bugzzilla.jpatest;

import com.bugzzilla.jpatest.Entity.College;
import com.bugzzilla.jpatest.Entity.Student;
import com.bugzzilla.jpatest.Repository.CollegeJpaRepository;
import com.bugzzilla.jpatest.Service.CollegeService;
import com.bugzzilla.jpatest.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaTestApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final CollegeService collegeService;
	private final StudentService studentService;

	@Autowired
	public JpaTestApplication(CollegeService collegeService, StudentService studentService) {
		this.collegeService = collegeService;
		this.studentService = studentService;
	}

	public static void main(String[] args) {

		SpringApplication.run(JpaTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) {


		collegeService.save(new College("Princeton University"));
		collegeService.save(new College("Harvard University"));
		collegeService.save(new College("University of Chicago"));
		collegeService.save(new College("Yale University"));
		collegeService.save(new College("Columbia University"));

		College college1 = collegeService.findByName("Columbia University");

		studentService.save(new Student("firstName1", "lastName1", "aa1@aa.com", "12345", college1));
		studentService.save(new Student("firstName2", "lastName2", "aa2@aa.com", "12345", college1));
		studentService.save(new Student("firstName3", "lastName3", "aa3@aa.com", "12345", college1));
	}
}
