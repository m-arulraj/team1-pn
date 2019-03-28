package com.virtusa.registrationconsumer.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.PostService;
import com.virtusa.registrationconsumer.service.RegisterService;

@Controller
@RequestMapping(value="api/user")
public class RegisterResource {

	@Autowired
	RegisterService registerService;
	
	@Autowired
	PostService  postService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String savePage(@ModelAttribute("user") User user, Model model) {
		registerService.saveUser(user);
		System.out.println("********************" + postService.getAllPosts());
		model.addAttribute(new Post());
		model.addAttribute("allPost",postService.getAllPosts() );
		model.addAttribute("user", user);
		return "home";
	}
	
	@RequestMapping(value="/searchByEmail/{email}",method=RequestMethod.GET)
	public User searchUserByEmail(@PathVariable(name="email") String Email){
		return registerService.searchByEmail(Email);
	}
	
	@RequestMapping(value="/searchBy/name/{name}",method=RequestMethod.GET)
	public List<User> searchUserByName(@PathVariable(name="name") String name){
		return registerService.searchByName(name);
	}
}
