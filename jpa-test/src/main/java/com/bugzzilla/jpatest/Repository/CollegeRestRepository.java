package com.bugzzilla.jpatest.Repository;

import com.bugzzilla.jpatest.Entity.College;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "college", path = "colleges")
public interface CollegeRestRepository extends PagingAndSortingRepository<College, Long> { }
