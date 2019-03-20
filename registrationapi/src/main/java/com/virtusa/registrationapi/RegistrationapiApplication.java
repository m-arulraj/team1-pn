package com.virtusa.registrationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegistrationapiApplication {

	public static void main(String[] args){
		SpringApplication.run(RegistrationapiApplication.class, args);
	}
}
