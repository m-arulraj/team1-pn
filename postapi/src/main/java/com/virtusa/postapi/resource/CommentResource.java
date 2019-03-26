package com.virtusa.postapi.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.postapi.domain.Comment;
import com.virtusa.postapi.service.CommentService;

@RestController
public class CommentResource {

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/api/post/comment/add/{postid},{userId}", method = RequestMethod.POST)
	private ResponseEntity<String> addComment(@RequestBody Comment comment, @PathVariable("postid") Long postId,
			@PathVariable("userId") Long userId) throws URISyntaxException {
		ResponseEntity<String> responseEntity = ResponseEntity
				.created(new URI("/api/post/comment/get/" + commentService.addComment(comment, postId, userId).getId()))
				.build();
		return responseEntity;
	}

	@RequestMapping(value = "/api/post/comment/edit/{cmtid},{message}", method = RequestMethod.PUT)
	private void editComment(@PathVariable("cmtid") Long commentId, @PathVariable("message") String message)
			throws URISyntaxException {

		commentService.editMessage(commentId, message);
	}

	@RequestMapping(value = "/api/post/comment/delete/{postid}", method = RequestMethod.DELETE)

	private void deleteComment(@PathVariable("postid") Long postId) throws URISyntaxException {

		commentService.deleteComment(postId);
	}

	@RequestMapping(value = "/api/post/all/comment/{postid}", method = RequestMethod.GET)
	private List<Comment> getAllComment(@PathVariable("postid") Long postId) throws URISyntaxException {

		List<Comment> listComment = commentService.getAllComment(postId);
		return listComment;
	}

}
