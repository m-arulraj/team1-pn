package com.virtusa.registrationapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AppTest {

	@Autowired
	private MockMvc mockmvc;
	@Autowired
	protected WebApplicationContext wac;

	@Before
    public void setup() throws Exception {
	this.mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
	
	}

	@Test
	public void registration() throws Exception {
		
	}

}
