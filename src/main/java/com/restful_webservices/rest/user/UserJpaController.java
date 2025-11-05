package com.restful_webservices.rest.user;

import com.restful_webservices.rest.post.Post;
import com.restful_webservices.rest.post.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    private final UserJpaService userJpaService;

    private final PostService postJpaService;

    public UserJpaController(UserJpaService userJpaService, PostService postJpaService) {
        this.userJpaService = userJpaService;
        this.postJpaService = postJpaService;
    }

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> findAll() {
        return userJpaService.findAll();
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public User findUser(@PathVariable("id") Integer id) {
        return userJpaService.findById(id);
    }

    @GetMapping(value = "/users/{id}/posts", produces = "application/json")
    public List<Post> findUserPosts(@PathVariable("id") Integer id) {
        return findUser(id).getPost();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createUserPost(@PathVariable("id") Integer id, @Valid @RequestBody Post post) {
        User user = findUser(id);
        Post post2 = postJpaService.savePost(post, user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post2.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userJpaService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
