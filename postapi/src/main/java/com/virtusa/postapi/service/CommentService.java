package com.virtusa.postapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.postapi.domain.Comment;
import com.virtusa.postapi.domain.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	public Comment addComment(Comment comment,Long postId,Long userId) {
		comment.setPostId(postId);
		comment.setUserId(userId);
		return commentRepository.save(comment);

	}
	
	@Transactional
	public void editMessage(Long id,String message){
		commentRepository.editCommentMessage(id, message);
	}

	@Transactional
	public void deleteComment(Long postId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(postId);
	}
	
	
	public List<Comment> getAllComment(Long postId) {
		List<Comment> listComment = new ArrayList<Comment>();
		listComment.addAll(commentRepository.getAllCommentInPost(postId));
		return listComment;
	}
}
