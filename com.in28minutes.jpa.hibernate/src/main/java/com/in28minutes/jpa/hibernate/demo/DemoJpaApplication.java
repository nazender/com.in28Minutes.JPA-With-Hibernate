package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... arg0) throws Exception {
//		repository.playWithEntityManager();
//		logger.info("Find all -> {}", repository.findAll());
//		logger.info("Find by name like Spring -> {}", repository.getByNameLike("%Spring%"));
//		logger.info("Find by name like Spring -> {}", repository.getByNameLikeNative("%Spring%"));

//		Course course = repository.findById(10001L);
//		if (course != null) {
//			course.setName("Hello");
//			repository.save(course);
//		}

//		Course course1 = new Course("Heelo1");
//		repository.save(course1);

		studentRepository.saveStudentWithPassport();
		logger.info("Student by id {}", studentRepository.findById(20001L));

	}

}
