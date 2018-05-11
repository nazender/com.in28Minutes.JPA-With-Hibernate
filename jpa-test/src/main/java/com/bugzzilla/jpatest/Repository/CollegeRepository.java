package com.bugzzilla.jpatest.Repository;

import com.bugzzilla.jpatest.Entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    College findByCollegeNameEqualsIgnoreCase (String collegeName);

}
