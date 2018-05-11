package com.bugzzilla.jpatest.Repository;

import com.bugzzilla.jpatest.Entity.College;
import com.bugzzilla.jpatest.Entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "student", path = "students")
public interface StudentRestRepository extends PagingAndSortingRepository<Student, Long> { }
