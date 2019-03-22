package com.virtusa.registrationapi;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegistrationapiApplication {

	public static void main(String[] args) {
		Logger logger = null;

		// get logger object.
		logger = Logger.getLogger(RegistrationapiApplication.class.getName());
		// configure logger object
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

		logger.debug("registration api started");
		SpringApplication.run(RegistrationapiApplication.class, args);
	}
}
