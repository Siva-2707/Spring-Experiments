package com.siva.socialmediaapp.Controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.siva.socialmediaapp.Bean.Post;
import com.siva.socialmediaapp.Bean.User;
import com.siva.socialmediaapp.Exception.PostNotFoundException;
import com.siva.socialmediaapp.Exception.UserNotFoundException;
import com.siva.socialmediaapp.Repository.PostRepository;
import com.siva.socialmediaapp.Repository.UserRepository;

@RestController
public class UserController {

    private UserRepository userRepo;
    private PostRepository postRepo;
    private MessageSource messageSource;

    // private UserFilter filter;
    public UserController(UserRepository userRepo, MessageSource messageSource, PostRepository postRepo) {
        this.userRepo = userRepo;
        this.messageSource = messageSource;
        this.postRepo = postRepo;
    }

    @GetMapping("/home")
    public Object greet() {
        Locale locale = LocaleContextHolder.getLocale();
        String str = messageSource.getMessage("message.greet", null, "Hello", locale).toString();
        return str;
    }

    //Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //Get user with a particular Id
    //If user doesn't exist, UserNotFoundException is thrown and response status is updated to 400 NOT_FOUND.
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    //Create new User
    //If created, response status is 201 CREATED.
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User createdUser = userRepo.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Delete existing user
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepo.deleteById(id);
    }

    //Getting Posts of a particular user.
    @GetMapping("/users/{id}/posts")
    public List<Post> getPostsOfAUser(@PathVariable int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent())
            return user.get().getPosts();
        throw new UserNotFoundException(id);
    }

    //Getting a particular post of a user. Logically wrong, needed to be enhanced.
    @GetMapping("users/{userId}/posts/{postId}")
    public Post getAParticularPostOfAUser(@PathVariable int userId, @PathVariable int postId) {
        if (userRepo.findById(userId).isPresent())
            return postRepo.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        throw new UserNotFoundException(userId);
    }

    @PostMapping("users/{userId}/posts")
    public ResponseEntity<Object> createPostForAUser(@PathVariable int userId, @RequestBody @Valid Post post) {
        userRepo.findById(userId).ifPresentOrElse(
                user -> {
                    post.setUser(user);
                    postRepo.save(post);
                }, () -> new UserNotFoundException(userId));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
