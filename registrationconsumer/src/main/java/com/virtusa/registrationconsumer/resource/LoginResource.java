package com.virtusa.registrationconsumer.resource;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.PostService;
import com.virtusa.registrationconsumer.service.UserService;

@Controller
@RequestMapping(value = "api")
public class LoginResource {

	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "login";
	}*/
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
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model,Principal principal,HttpSession session) {
		model.addAttribute("user", new User());
		String username = principal.getName();
		model.addAttribute("email", principal.getName());
		model.addAttribute("post",new Post());
		model.addAttribute("listPost", postService.getAllpost());
		model.addAttribute("user", new User());
		session.setAttribute("email",principal.getName());
		return "home";
	}
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("loginUser")User user2,Model model,HttpSession session) {
		
		User user=userService.login(user2.getEmail(), user2.getPassword());
		if(user!=null && user.getId()!=null){
			model.addAttribute("email", user.getEmail());
			model.addAttribute("post",new Post());
			model.addAttribute("listPost", postService.getAllpost());
			model.addAttribute("user", new User());
			session.setAttribute("email", user.getEmail());
			return "home";
		}else{
			model.addAttribute("loginUser",new User());
			model.addAttribute("error", "Enter Correct Details");
			return "login";
		}*/
		
		
	
	
	// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

			ModelAndView model = new ModelAndView();

			// check if user is login
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				model.addObject("username", userDetail.getUsername());
			}

			model.setViewName("403");
			return model;

		}
}
