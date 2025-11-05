package com.restful_webservices.rest.post;

import com.restful_webservices.rest.helloworld.UserNotFoundException;
import com.restful_webservices.rest.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllPosts(){
        return postRepository.findAll();
    }

    public Post savePost(Post post, User user){
        post.setUser(user);
        return postRepository.saveAndFlush(post);
    }

    public Post getPostById(Integer id){
        return postRepository.findById(id).orElseThrow(()-> new UserNotFoundException(String.format("Post with id %s not found", id )));
    }
}
