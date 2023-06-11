package com.siva.jpademo.Repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.siva.jpademo.Model.Course;

@Repository
@Transactional
public class JpaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertCourse(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        entityManager.remove(findById(id));
    }
}
