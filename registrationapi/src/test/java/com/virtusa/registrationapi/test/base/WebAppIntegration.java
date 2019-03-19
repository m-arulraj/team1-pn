package com.virtusa.registrationapi.test.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import spock.lang.Specification;

public class WebAppIntegration extends Specification {

	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext wac;
	
		void setup(){
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
}
