package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager em) {
        this.entityManager = em;
    }

    public void insert(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployees() {
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

}
