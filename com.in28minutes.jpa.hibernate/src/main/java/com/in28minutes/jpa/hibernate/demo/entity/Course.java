package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses",
                query = "Select  c  From Course c"),
        @NamedQuery(name = "query_get_100_Step_courses",
                query = "Select  c  From Course c where name like '%100 Steps'") })
@Table(name = "Course_Details")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "fullname", nullable = false)
    private String name;

    @OneToMany(mappedBy="course")
    private List<Review> reviews = new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }


}
