package com.virtusa.postapi.resource;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.postapi.domain.Post;
import com.virtusa.postapi.service.PostService;

@RestController
@RequestMapping(value="/api/post")
public class PostResource {

	@Autowired
	PostService postService;

	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
	public String savePost(@RequestBody Post post, @PathVariable("id") Long id) throws URISyntaxException {
		postService.addPost(post, id);
		/*
		 * ResponseEntity<String> response = ResponseEntity .created(new
		 * URI("/api/post/add/" + postService.addPost(post,
		 * id).getId())).build();
		 */
		return "done!";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deletepost(@PathVariable("id") Long id) throws URISyntaxException {

		postService.deletePost(id);
	}

	@RequestMapping(value = "/all/posts/", method = RequestMethod.GET)
	private List<Post> getAllPosts() throws URISyntaxException {

		List<Post> listComment = postService.getAllPosts();
		return listComment;
	}
}
