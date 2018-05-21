package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;

    protected FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
