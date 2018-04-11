package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourceCrudRepositry;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class DemoCrudApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourceCrudRepositry crudRepository;

	@Override
	public void run(String... arg0) throws Exception {

		Course course = new Course("Hello");
		crudRepository.save(course);

		logger.info("Course by name -> {}", crudRepository.findByName("Hello"));
		logger.info("Find all -> {}", crudRepository.findAll());
		logger.info("Find by Id 10001 -> {}", crudRepository.findById(10001L));
		crudRepository.deleteById(1L);
		logger.info("Find all -> {}", crudRepository.findAll());

	}


}
