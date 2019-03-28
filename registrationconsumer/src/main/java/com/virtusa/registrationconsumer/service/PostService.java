package com.virtusa.registrationconsumer.service;

import java.util.List;

import com.virtusa.registrationconsumer.domain.Post;

public interface PostService {

	public void addPost(Post post, Long userId);

	public void deletePost(Long id);

	public List<Post> getAllPosts();

}
