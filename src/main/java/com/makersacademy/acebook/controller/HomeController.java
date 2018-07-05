package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.makersacademy.acebook.model.Post;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@Autowired
	PostRepository postRepository;

	@GetMapping("/posts")
	public List<Post> otherIndex(){
		return postRepository.findAll();
	}

	@PostMapping("/posts")
	public Post create(@RequestBody Map<String, String> body){
		String content = body.get("content");
		return postRepository.save(new Post(content));
	}

//	@PutMapping("/post/{id}")
//	public Post update(@PathVariable String id, @RequestBody Map<String, String> content){
//		int postId = Integer.parseInt(id);
//		Post post = postRepository.findOne(postId);
//		post.setContent(content.get("content"));
//		return postRepository.save(post);
//	}
}
