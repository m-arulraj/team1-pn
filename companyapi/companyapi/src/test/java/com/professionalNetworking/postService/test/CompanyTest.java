package com.professionalNetworking.postService.test;

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
import com.professionalNetworking.postService.domain.Company;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyTest {

	public MockMvc mvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test() throws Exception {
		Company c = new Company();
		c.setName("Virtusa");
		c.setBased("product");
		c.setCeo("raju");
		c.setClients("PNC");
		c.setEstablished("2010");
		c.setNoofEmployees(200L);

		String result = mvc
				.perform(MockMvcRequestBuilders.post("/api/company").contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(c)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location")
				.toString();

		if (result != null) {

			String uri = "/api/company/2";

			String response = mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
			System.out.println(response);

		}
	}

	@Test
	public void deleteTest() throws Exception {

		String deleteuri = "/api/company/deletecompany/7";

		mvc.perform(MockMvcRequestBuilders.delete(deleteuri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void updateTest() throws Exception {

		String updateUri = "/api/company/updatecompany/13/name/polaris";

		mvc.perform(MockMvcRequestBuilders.put(updateUri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(new Company()))).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
