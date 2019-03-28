package com.virtusa.registrationconsumer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.virtusa.registrationconsumer.domain.Education;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.UserService;

@Controller
@RequestMapping("api/user/profile")
public class ProfileResource {

	@Autowired
	UserService userService;
	
	@RequestMapping("")
	private String profile() {
		
		return "updateprofile";
	}
	
	@RequestMapping("/c")
	private String profileView(@SessionAttribute("user") User user) {
		

		System.out.println(user.getName()+"*********************");
		return "viewprofile";
	}
	@RequestMapping(value="/education",method=RequestMethod.POST)
	private String education(@ModelAttribute("education")Education education) {
		
		return "updateprofile";
	}
	
}
