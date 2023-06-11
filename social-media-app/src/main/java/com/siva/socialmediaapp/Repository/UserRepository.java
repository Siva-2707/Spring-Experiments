package com.siva.socialmediaapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.socialmediaapp.Bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
