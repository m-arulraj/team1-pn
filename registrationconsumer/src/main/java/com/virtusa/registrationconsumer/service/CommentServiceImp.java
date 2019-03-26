package com.virtusa.registrationconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.registrationconsumer.domain.Comment;
import com.virtusa.registrationconsumer.util.EndpointConstant;

@Service
public class CommentServiceImp implements CommentService {

	
	@Autowired
	RestTemplate restTemplate;
	@Override
	public void savecomment(Comment comment, Long postId, Long userId) {
		
		restTemplate.postForObject(EndpointConstant.POST_SERVICE_URI, comment, String.class,postId,userId);
		
	}

}
