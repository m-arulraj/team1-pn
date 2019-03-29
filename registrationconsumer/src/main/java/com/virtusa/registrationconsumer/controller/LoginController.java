/*package com.virtusa.registrationconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.registrationconsumer.domain.User;

@Controller
@RequestMapping(value="/loginsfdds")
public class LoginController {

	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody String  savePage(@ModelAttribute("loginUser") User user,Model model){
		System.out.println(user.getName());
		return "login";
	}
}
*/