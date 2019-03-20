package com.virtusa.registrationapi.Test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.virtusa.registrationapi.domain.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegistrationTest {

	public MockMvc mvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test() throws Exception {
		User user = new User();
		user.setName("mukul");
		user.setEmail("mukul@gmail.com");
		user.setDob("2016-03-12");
		user.setPhone(999999999999L);
		user.setGender("male");
		user.setCountry("india");
		user.setState("up");
		user.setPassword("mukul");

		String uri = "/registeruser";
		ResultActions result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user))).andExpect(MockMvcResultMatchers.status().isCreated());
		System.out.println(result);
	}
	
	

}
