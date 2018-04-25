package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private final EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
        //TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_cources", Course.class);
        return query.getResultList();
    }

    public List<Course> getByNameLike(String likeName) {
//        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like :name", Course.class).setParameter("name", likeName);
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_like_cources", Course.class).setParameter("name", likeName);
        return query.getResultList();
    }

    public List getByNameLikeNative(String likeName) {
//        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c where name like :name", Course.class).setParameter("name", likeName);
        Query query = entityManager.createNativeQuery("SELECT * FROM Course_Details WHERE fullname like :name", Course.class).setParameter("name", likeName);
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

    public void addHardcodedReviewsForCourse() {
        //get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {}", course.getReviews());

        //add 2 reviews to it
        Review review1 = new Review("5", "Great Hands-on Stuff.");
        Review review2 = new Review("5", "Hatsoff.");

        //setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        //save it to the database
        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);

        if (course != null) {
            logger.info("course.getReviews() -> {}", course.getReviews());
            for (Review review : reviews) {
                //setting the relationship
                course.addReview(review);
                review.setCourse(course);
                entityManager.persist(review);
            }
        } else {
            logger.info("course {} not exista", courseId);
        }
    }

}
