package com.bugzzilla.jpatest.Entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;

    @Column(length = 32)
    private String documentId;

    @ManyToOne(fetch = FetchType.EAGER)
    private College college;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentId() {
        return documentId;
    }

    public College getCollege() {
        return college;
    }

    public Student(String firstName, String lastName, String email, String documentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.documentId = documentId;
    }

    public Student(String firstName, String lastName, String email, String documentId, College college) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.documentId = documentId;
        this.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", documentId='" + documentId + '\'' +
                ", college=" + college.getId() + ":" + college.getCollegeName() +
                '}';
    }
}
