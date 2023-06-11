package com.siva.socialmediaapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.socialmediaapp.Bean.Post;
import com.siva.socialmediaapp.Bean.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

    public List<Post> findByUser(User user);

}
