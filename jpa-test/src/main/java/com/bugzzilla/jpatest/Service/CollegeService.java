package com.bugzzilla.jpatest.Service;

import com.bugzzilla.jpatest.Entity.College;
import com.bugzzilla.jpatest.Entity.Student;
import com.bugzzilla.jpatest.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CollegeService {

    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public College save(College college) {
        return collegeRepository.save(college);
    }

    public College findByName(String name) {
        return collegeRepository.findByCollegeNameEqualsIgnoreCase(name);
    }

    public List<College> findAll() {
        return collegeRepository.findAll();
    }

}
