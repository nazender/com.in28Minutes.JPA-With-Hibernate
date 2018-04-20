package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager entityManager;

    //Session & Session Factory


    //EntityManager & Persistence Context
    //Transaction

    @Test
    @Transactional
    public void someTest() {
        Student student = entityManager.find(Student.class, 20001L);
        Passport passport = student.getPassport();
        passport.setNumber("EHello");
        student.setName("Anton");
    }


    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}",student.getPassport());
    }
}