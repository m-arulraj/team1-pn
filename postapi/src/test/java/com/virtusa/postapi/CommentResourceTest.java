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
import com.virtusa.postapi.domain.Comment;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentResourceTest {
	@Autowired
	WebApplicationContext applicationContext;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void saveComment() throws Exception {
		String uri = "/api/post/comment/add/26,1";

		Comment comment = new Comment();
		comment.setDate("2019-03-21");
		comment.setMessage("Good bro");

		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(comment))).andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	public void editComment() throws Exception {
		String msg = "nice post";
		String uri = "/api/post/comment/edit/19," + msg;

		

		mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	/*@Test
	public void deleteComment() throws Exception {
		
		String uri = "/api/post/comment/delete/18" ;

		

		mockMvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	*/
	@Test
	public void getAllComment() throws Exception {
		
		String uri = "/api/post/all/comment/10" ;

		

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
