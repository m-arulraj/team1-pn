package com.virtusa.registrationconsumer.service;

import com.virtusa.registrationconsumer.domain.Post;

public interface PostService {

	public void addPost(Post post, Long userId);

	public void deletePost(Long id);

}
