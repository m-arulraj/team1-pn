package com.virtusa.registrationconsumer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.registrationconsumer.domain.Comment;
import com.virtusa.registrationconsumer.service.CommentService;

@Controller
public class CommentResource {
	
	@Autowired 
	CommentService commentService;

	@RequestMapping(value="api/comment/{postid}/user/{userid}" ,method=RequestMethod.POST)
	public void postComment(@ModelAttribute(name="comment") Comment comment,@PathVariable(name="postid") Long postId,
			@PathVariable(name="userid") Long userId){
		
		  commentService.savecomment(comment,postId,userId);
		
	}
	
	
}
