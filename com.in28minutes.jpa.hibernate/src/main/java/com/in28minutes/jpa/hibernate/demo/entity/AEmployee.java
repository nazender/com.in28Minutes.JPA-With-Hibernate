package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class AEmployee extends Employee {


    private String value;

    public AEmployee() {
    }

    public AEmployee(String name, String value) {
        super(name);
        this.value = value;
    }

    @Override
    public String toString() {
        return "AEmployee{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
