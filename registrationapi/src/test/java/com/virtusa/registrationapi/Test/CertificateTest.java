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
import com.virtusa.registrationapi.domain.Certificate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CertificateTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test()throws Exception{
		
		Certificate certificate = new Certificate();
		certificate.setInstituteName("virtusa");
		
		String uri="/api/user/registration/addcertificate/mukul.com";
		
		String result=mockMvc.perform(MockMvcRequestBuilders.post(uri).
				contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(certificate))).
				andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getRequest().getHeader("Loction").toString();
		
		if(result!=null){
			mockMvc.perform(MockMvcRequestBuilders.get("/api/user/registration/getskill/1")
					.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		}
	}
}
