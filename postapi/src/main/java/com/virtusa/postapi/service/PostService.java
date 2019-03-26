package com.virtusa.postapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.postapi.domain.Post;
import com.virtusa.postapi.domain.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post addPost(Post post,Long userId){
		post.setUserId(userId);
		return postRepository.save(post);
	}
	
	@Transactional
	public void deletePost(Long postId){
		postRepository.deleteById(postId);
	}

	public List<Post> getAll() {
		
		return postRepository.findAll();
	}
}
