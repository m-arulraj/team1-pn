package com.virtusa.registrationconsumer.resource;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.PostService;
import com.virtusa.registrationconsumer.service.UserService;

@Controller
@RequestMapping(value = "/api/user/post")
public class PostResource {

	@Autowired
	PostService postService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/upost", method = RequestMethod.POST)
	public String addPost( @RequestParam("message") String msg,HttpSession session,Principal principal, Model model) {
		
	
		//User user=(User) session.getAttribute("user");
		
		System.out.println(session.getAttribute("email"));
		String email=(String)session.getAttribute("email");
		User user=userService.getUserByEmail(email);
		Post post = new Post();
		post.setMessage(msg);
		postService.addPost(post,user.getId());
		model.addAttribute("post",user.getEmail());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("listPost", postService.getAllpost());
		model.addAttribute("user", new User());
		return "redirect:/api/home";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable(name = "id") Long id) {

		postService.deletePost(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void getAllPost() {

	}

}
