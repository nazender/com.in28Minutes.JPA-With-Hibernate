package com.bugzzilla.jpatest.Entity;

import javax.persistence.*;
import java.util.*;


@Entity
public class College{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String collegeName;

    @OneToMany(mappedBy = "college", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    public College() {
    }

    public College(String collegeName) {
        this.collegeName = collegeName;
    }

    public College(String collegeName, List<Student> students) {
        this.collegeName = collegeName;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", collegeName='" + collegeName + '\'' +
                ", students=" + this.getStudents() +
                '}';
    }
}
