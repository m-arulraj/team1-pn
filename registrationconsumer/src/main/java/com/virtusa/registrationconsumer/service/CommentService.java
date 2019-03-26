package com.virtusa.registrationconsumer.service;

import com.virtusa.registrationconsumer.domain.Comment;

public interface CommentService {

	public void savecomment(Comment comment, Long postId, Long userId);

}
