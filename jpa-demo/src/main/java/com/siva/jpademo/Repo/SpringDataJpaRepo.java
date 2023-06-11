package com.siva.jpademo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siva.jpademo.Model.Course;

@Repository
public interface SpringDataJpaRepo extends JpaRepository<Course, Long> {
}
