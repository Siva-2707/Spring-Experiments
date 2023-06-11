package com.siva.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.siva.jpademo.Model.Course;
import com.siva.jpademo.Repo.JdbcRepo;
import com.siva.jpademo.Repo.SpringJdbcRepo;

@Component
@Order(1)
public class JdbcAndSpringJdbcRunner implements CommandLineRunner {

    @Autowired
    private SpringJdbcRepo repo;

    @Autowired
    private JdbcRepo jdbcRepo;

    @Override
    public void run(String... args) throws Exception {
        repo.insert();
        repo.insert(new Course(2, "LearnAWS", "In 28Minutes"));
        jdbcRepo.insert();
    }

}
