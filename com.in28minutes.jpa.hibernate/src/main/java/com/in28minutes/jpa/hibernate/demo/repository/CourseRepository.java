package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {

        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }

    public List<Course> findAll() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
        return query.getResultList();
    }

    public List<Course> getByNameLike(String likeName) {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like :name", Course.class).setParameter("name", likeName);
        return query.getResultList();
    }


    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        entityManager.persist(course1);

        Course course2 = new Course("Angular Js in 100 Steps");
        entityManager.persist(course2);

        entityManager.flush();

        course1.setName("Web Services in 100 Steps - Updated");
        //course2.setName("Angular Js in 100 Steps - Updated");

        //entityManager.refresh(course1);

        entityManager.flush();

    }

}
