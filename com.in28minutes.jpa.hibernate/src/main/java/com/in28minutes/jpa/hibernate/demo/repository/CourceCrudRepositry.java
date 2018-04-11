package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CourceCrudRepositry extends CrudRepository<Course, Long> {

    List<Course> findByName(String name);
    Optional<Course> findById(Long id);

    @Override
    void deleteById(Long aLong);
}
