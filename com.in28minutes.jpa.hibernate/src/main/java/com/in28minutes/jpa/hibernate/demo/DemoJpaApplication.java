package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

//@Component
public class DemoJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final CourseRepository courseRepository;

	private final StudentRepository studentRepository;

	@Autowired
	EntityManager em;

	@Autowired
	public DemoJpaApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
		this.courseRepository = courseRepository;
		this.studentRepository = studentRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		List<Review> reviews = new ArrayList<>();

		reviews.add(new Review("5", "Great Hands-on Stuff."));
		reviews.add(new Review("5", "Hatsoff."));

		courseRepository.addReviewsForCourse(10003L, reviews );

		Course course = courseRepository.findById(10003L);
		logger.info("Course {}", course.getReviews());

//		Review review = em.find(Review.class, 1);
// 		logger.info("{}", review.getCourse());

	}

}
