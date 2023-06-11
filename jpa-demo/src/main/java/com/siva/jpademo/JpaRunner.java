package com.siva.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.siva.jpademo.Model.Course;
import com.siva.jpademo.Repo.JpaRepo;

@Component
@Order(2)
public class JpaRunner implements CommandLineRunner {

    @Autowired
    private JpaRepo jpaRepo;

    @Override
    public void run(String... args) throws Exception {
        //Inserting new Course
        jpaRepo.insertCourse(new Course(4, "From Jpa Repo", "Siva"));
    }

}
