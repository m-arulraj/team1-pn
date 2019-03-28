package com.virtusa.registrationconsumer.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.service.PostService;

@Controller
@RequestMapping(value = "/api/post")
public class PostResource {

	@Autowired
	PostService postService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post post, @PathVariable(name = "userId") Long userId) {

		
		return "Home";

	}

	@RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable(name = "postId") Long id) {

		postService.deletePost(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Post> getAllPost() {

		return postService.getAllPosts();
	}
}
