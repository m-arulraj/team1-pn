package com.virtusa.registrationconsumer.resource;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.PostService;
import com.virtusa.registrationconsumer.service.RegisterService;

@Controller
@RequestMapping("api")
@SessionAttributes("user")
public class RegisterResource {

	@Autowired
	RegisterService registerService;

	@Autowired
	PostService postService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, Model model,HttpSession session) {
		registerService.saveUser(user);

		model.addAttribute("email", user.getEmail());
		model.addAttribute("post",new Post());
		model.addAttribute("listPost", postService.getAllpost());
		model.addAttribute("user", new User());
		session.setAttribute("email", user.getEmail());
		return "home";
	}

	@RequestMapping(value = "/searchByEmail/{email}", method = RequestMethod.GET)
	public User searchUserByEmail(@PathVariable(name = "email") String email,HttpSession session) {

		session.setAttribute("email", email);
		return registerService.searchByEmail(email);
	}

	@RequestMapping(value = "/searchBy/name/{name}", method = RequestMethod.GET)
	public List<User> searchUserByName(@PathVariable(name = "name") String name) {

		return registerService.searchByName(name);
	}

}
