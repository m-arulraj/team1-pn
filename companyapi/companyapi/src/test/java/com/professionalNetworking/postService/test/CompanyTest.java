package com.professionalNetworking.postService.test;

import java.io.UnsupportedEncodingException;

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
		c.setId(1L);
		c.setName("Virtusa");
		c.setAddress("Chennai");
		c.setPassword("123456");
		c.setEmail("virtusapolaris.in@virtusa.com");
		c.setAboutUs("Virtusa provides end-to-end digital transformation and information technology (IT)");
		c.setContactNumber("9999999999");
		mvc.perform(MockMvcRequestBuilders.post("/api/companies").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(c))).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn()
				.getResponse().getHeader("Location").toString();
	}

	@Test
	public void getTest() throws UnsupportedEncodingException, Exception {
		String uri = "/api/getCompanyById/1";

		mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

	}

	@Test
	public void deleteTest() throws Exception {

		String deleteuri = "/api/company/deleteCompanyById/1";

		mvc.perform(MockMvcRequestBuilders.delete(deleteuri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void updateTest() throws Exception {

		String updateUri = "/api/company/updateCompanyById/13/updateName/polaris";

		mvc.perform(MockMvcRequestBuilders.put(updateUri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(new Company()))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getAllCompanies() throws Exception {

		String getAllCompanies = "/api/companies/all";

		mvc.perform(MockMvcRequestBuilders.get(getAllCompanies).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
