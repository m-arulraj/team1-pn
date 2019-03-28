package com.virtusa.registrationconsumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.util.EndpointConstant;

@Service
public class PostServiceImp implements  PostService {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public void addPost(Post post, Long userId) {
		
		
		
		
		//Map<String,String> params= new HashMap<String,String>();
		//params.put("userId","1");
		
		/* HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      HttpEntity<Post> entity = new HttpEntity<Post>(post,headers);*/
		//HttpEntity<Post> entity = new HttpEntity<Post>(postDomain);
	     /* restTemplate.exchange(
	    		  EndpointConstant.POST_SERVICE_URI+userId, HttpMethod.POST, entity, String.class);*/
		
	     restTemplate.postForObject(EndpointConstant.POST_SERVICE_URI+""+userId, post, String.class);
	     /*putForObject(EndpointConstant.POST_SERVICE_URI+userId,HttpMethod.POST,entity);*/
		
		//restTemplate.exchange(EndpointConstant.POST_SERVICE_URI+userId,HttpMethod.POST,entity,String.class);
	}
	      
		


	@Override
	public void deletePost(Long id) {
		
		restTemplate.delete(EndpointConstant.POST_SERVICE_URI, id);
		
	}




	@Override
	public List<Post> getAllPosts() {
		ResponseEntity<List<Post>> response = restTemplate.exchange(EndpointConstant.POST_SERVICE_URI,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
				});
		return response.getBody();
	}

}
