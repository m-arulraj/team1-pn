package com.virtusa.registrationconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.registrationconsumer.domain.User;

@Controller
public class RegisterController {

	@RequestMapping(value="/register",method=RequestMethod.GET)
	String registerPage(Model model){
		model.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody String  savePage(@ModelAttribute("user") User user,Model model){
		System.out.println(user.getEmail());
		System.out.println(user.getGender());
		return "register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	String loginPage(Model model){
		model.addAttribute("loginUser",new User());
		return "login";
	}
}