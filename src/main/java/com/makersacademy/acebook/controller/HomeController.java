package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makersacademy.acebook.model.Post;

import java.util.List;

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
}
