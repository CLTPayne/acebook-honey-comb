package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Authenticator;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UserRepository;
import main.java.com.makersacademy.acebook.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/posts")
    public Object createPost(@RequestBody Map<String,String> body) {
        String content = body.get("content");
        String token = body.get("token");
        Long userId  = Authenticator.returnIdFromToken(userRepository, token);
            if(userId == null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Response("user could not be matched to a token"));
            }
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.save(new Post(content, userId)));
    }

    @GetMapping("/posts")
    public Iterable<Post> getPost(){
        return postRepository.findAll();
    }
}
