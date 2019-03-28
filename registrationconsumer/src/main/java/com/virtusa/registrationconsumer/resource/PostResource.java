package com.virtusa.registrationconsumer.resource;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

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
	public String addPost( @RequestParam("message") String msg, @RequestParam("email") String email, Model model) {
		
	
		//User user=(User) session.getAttribute("user");
		
		System.out.println(email);
		User user=userService.getUserByEmail(email);
		Post post = new Post();
		post.setMessage(msg);
		postService.addPost(post,user.getId());
		model.addAttribute("post",email);
		model.addAttribute("email", user.getEmail());
		model.addAttribute("listPost", postService.getAllpost());
		model.addAttribute("user", new User());
		return "home";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable(name = "id") Long id) {

		postService.deletePost(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void getAllPost() {

	}

}
