package com.bugzzilla.jpatest.Repository;

import com.bugzzilla.jpatest.Entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CollegeJpaRepository {


    private final EntityManager entityManager;

    @Autowired
    public CollegeJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public College save(College college) {
        if (college.getId() == null) {
            entityManager.persist(college);
        } else {
            entityManager.merge(college);
        }
        return college;
    }

    public College findByName(String name) {
        TypedQuery<College> namedQuery = entityManager.createQuery("select c from College c where upper(collegeName) = :name", College.class)
                                                      .setParameter("name", name.toUpperCase());
        return namedQuery.getSingleResult();
    }

    public College findById(int id) {
        return entityManager.find(College.class, id);
    }

    public List<College> findAll() {
        TypedQuery<College> namedQuery = entityManager.createQuery("select c from College c", College.class);
        return namedQuery.getResultList();
    }


}
