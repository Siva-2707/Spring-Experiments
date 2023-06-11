package com.siva.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.siva.jpademo.Model.Course;
import com.siva.jpademo.Repo.SpringDataJpaRepo;

@Component
@Order(2)
public class SpringDataJpaRunner implements CommandLineRunner {

    @Autowired
    private SpringDataJpaRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Course(5, "From Spring Data JPA", "Siva"));
        repo.findAll().forEach(System.out::println);
        ;

    }

}
