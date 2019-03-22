package com.virtusa.postapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.postapi.domain.Post;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PostResourceTest {

	public MockMvc mockMvc;

	@Autowired
	WebApplicationContext applicationContext;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void saveEducation() throws Exception {
		String uri = "/api/post/save/1";

		Post post = new Post();
		post.setDate("2018-03-21");
		post.setLikes(2L);
		post.setMessage("Added second Post");

		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(post))).andExpect(MockMvcResultMatchers.status().isCreated());

	}
	
	@Test
	public void deletePost() throws Exception{
		String uri = "/api/post/delete/26";
		
		mockMvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
