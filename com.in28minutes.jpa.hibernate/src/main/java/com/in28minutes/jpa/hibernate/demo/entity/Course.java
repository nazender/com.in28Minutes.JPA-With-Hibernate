package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CourseDetails")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "fullname", nullable = false, length = 100)
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId()) &&
                Objects.equals(getName(), course.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
