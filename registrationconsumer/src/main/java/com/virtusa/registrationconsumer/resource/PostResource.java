package com.virtusa.registrationconsumer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.service.PostService;

@Controller
public class PostResource {

	@Autowired
	PostService postService;

	@RequestMapping(value = "/api/addpost/{userid}", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post post, @PathVariable(name = "userid") Long userId) {

		
		postService.addPost(post, userId);
		return "Home";

	}

	@RequestMapping(value = "/api/removepost/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable(name = "id") Long id) {

		postService.deletePost(id);
	}

}
