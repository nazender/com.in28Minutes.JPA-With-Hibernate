package com.bugzzilla.jpatest.Repository;

import com.bugzzilla.jpatest.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {
}
