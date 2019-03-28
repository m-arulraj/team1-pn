package com.virtusa.registrationconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="api/post/gdh")
public class PostConsumerController {

	
	@RequestMapping(value="",method=RequestMethod.GET)
	String addPost(){
		return "post";
	}
	
	@RequestMapping(value="comment",method=RequestMethod.GET)
	String comment(){
		return "comment";
	}
}
