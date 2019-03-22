package com.virtusa.postapi.resource;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.postapi.domain.Post;
import com.virtusa.postapi.service.PostService;

@RestController
public class PostResource {

	@Autowired
	PostService postService ;

	@RequestMapping(value = "/api/post/save/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> savePost(@RequestBody Post post, @PathVariable("id") Long id)
			throws URISyntaxException {
		
		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/post/add/" + postService.addPost(post,id).getId())).build();
		return response;
	}
	
	@RequestMapping(value = "/api/post/delete/{id}", method = RequestMethod.DELETE)
	public void deletepost( @PathVariable("id") Long id)
			throws URISyntaxException {
		
		postService.deletePost(id);
	}
}
