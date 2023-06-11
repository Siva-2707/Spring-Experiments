package com.siva.socialmediaapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.siva.socialmediaapp.Bean.User;
import com.siva.socialmediaapp.Repository.UserRepository;

// @Component
public class CMDRunner implements CommandLineRunner {

    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new User("Siva", LocalDate.now().minusYears(22)));
        repo.save(new User("Bharadhan", LocalDate.of(2000, 03, 20)));
    }

}
