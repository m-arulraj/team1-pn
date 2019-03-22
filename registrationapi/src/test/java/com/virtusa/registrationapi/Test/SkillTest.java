package com.virtusa.registrationapi.Test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.registrationapi.domain.Skill;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SkillTest {

	public MockMvc mvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test() throws Exception {
		Skill skill = new Skill();
		skill.setName("Java");

		String uri = "/api/user/registration/addskill";
		String result = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(skill)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse()
				.getHeader("Location")
				.toString();

		if (result != null) {

			mvc.perform(MockMvcRequestBuilders.get("/api/user/registration/addskill/1")
					.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		}
	}

}
