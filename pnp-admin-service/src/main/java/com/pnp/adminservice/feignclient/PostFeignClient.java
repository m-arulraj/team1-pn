package com.pnp.adminservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pnp.adminservice.domain.Post;

@FeignClient(value = "post-service", path = "/api/post")
public interface PostFeignClient {

	@RequestMapping(value = "/all/posts/", method = RequestMethod.GET)
	public List<Post> getAllPosts();

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deletePostById(Long id);

}
