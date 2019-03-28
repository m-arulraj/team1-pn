package com.virtusa.registrationconsumer.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.PostService;
import com.virtusa.registrationconsumer.service.UserService;

@Controller
@RequestMapping(value = "api/user")
public class LoginResource {

	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginUser",new User());
		
		return "login";

	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
   public String savePage(@ModelAttribute("loginUser") User user, Model model) {
		System.out.println(user.getName());
		return "login";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String logout( SessionStatus status) {
		
		status.setComplete();
		
		return "index";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("loginUser")User user2,Model model) {
		
		User user=userService.login(user2.getEmail(), user2.getPassword());
		if(user!=null && user.getId()!=null){
			model.addAttribute("email", user.getEmail());
			model.addAttribute("post",new Post());
			model.addAttribute("listPost", postService.getAllpost());
			model.addAttribute("user", new User());
			return "home";
		}else{
			model.addAttribute("loginUser",new User());
			model.addAttribute("error", "Enter Correct Details");
			return "login";
		}
		
		
	}
}
