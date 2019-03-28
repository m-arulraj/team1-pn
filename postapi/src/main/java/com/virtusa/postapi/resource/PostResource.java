package com.virtusa.postapi.resource;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.virtusa.postapi.domain.Post;
import com.virtusa.postapi.service.PostService;

@RestController
@RequestMapping(value = "/api/post")
public class PostResource {

	@Autowired
	PostService postService;

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> savePost(@RequestBody Post post, @PathVariable("id") Long id)
			throws URISyntaxException {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		post.setDate(strDate);
		post.setLikes(0L);
		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/post/" + postService.addPost(post, id).getId())).build();
		return response;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<Post> getAllPost() {
		// TODO Auto-generated method stub

		List<Post> listPost = postService.getAll();
		return listPost;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletepost(@PathVariable("id") Long id) throws URISyntaxException {
		postService.deletePost(id);
	}
	/*@RequestMapping(value = "/api/post/all/posts/", method = RequestMethod.GET)
	private List<Post> getAllPosts() throws URISyntaxException {

		List<Post> listComment = postService.getAllPosts();
		return listComment;
	}*/
}
