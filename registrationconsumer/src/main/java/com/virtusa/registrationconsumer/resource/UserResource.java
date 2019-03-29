package com.virtusa.registrationconsumer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.UserService;

@Controller
@RequestMapping(value="api/user")
public class UserResource {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	private String searchByUserName(@RequestParam("name")String name,@RequestParam("type")String type,Model model) {
		// TODO Auto-generated method stub

		model.addAttribute(new User());
		if(type.equals("name")){
			
		}else if(type.equals("skill")){
			
		}
		model.addAttribute("users", userService.searchByName(name));
		
		return "userlist";
	}
}
