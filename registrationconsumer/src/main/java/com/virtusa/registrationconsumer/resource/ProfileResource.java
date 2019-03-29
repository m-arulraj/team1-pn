package com.virtusa.registrationconsumer.resource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.virtusa.registrationconsumer.domain.Certificate;
import com.virtusa.registrationconsumer.domain.Education;
import com.virtusa.registrationconsumer.domain.Project;
import com.virtusa.registrationconsumer.domain.Skill;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.service.UserService;

@Controller
@RequestMapping("api/user/profile")
public class ProfileResource {

	@Autowired
	UserService userService;
	
	@RequestMapping("")
	private String profile(Model model,HttpSession session) {
		model.addAttribute(new Skill());
		model.addAttribute(new Education());
		model.addAttribute(new Project());
		model.addAttribute(new Certificate());
		System.out.println(session.getAttribute("email"));
		return "updateprofile";
	}
	
	@RequestMapping("/c")
	private String profileView() {
		return "viewprofile";
	}
	@RequestMapping(value="/skill",method=RequestMethod.POST)
	private String education(@ModelAttribute("skill")Skill skill,Model model,HttpSession session) {

		System.out.println(skill.getName());
		String email=(String)session.getAttribute("email");
		userService.saveSkill(email, skill);
		System.out.println("*************");
		return "redirect:/api/user/profile";
	}
	@RequestMapping(value="/certificate",method=RequestMethod.POST)
	private String certificate(@ModelAttribute("certificate")Certificate certificate,Model model,HttpSession session) {

		System.out.println(certificate.getInstituteName());
		String email=(String)session.getAttribute("email");
		userService.saveCertificate(email, certificate);
		System.out.println("*************");
		return "redirect:/api/user/profile";
	}
	
	@RequestMapping(value="/education",method=RequestMethod.POST)
	private String education(@ModelAttribute("education")Education education,Model model,HttpSession session) {

		System.out.println(education.getHighschool()+"*************");
		String email=(String)session.getAttribute("email");
		userService.saveEducation(email, education);
		System.out.println("*************");
		return "redirect:/api/user/profile";
	}
	
	@RequestMapping(value="/project",method=RequestMethod.POST)
	private String education(@ModelAttribute("project")Project project,Model model,HttpSession session) {

		System.out.println(project.getType());
		String email=(String)session.getAttribute("email");
		userService.saveProject(email, project);
		System.out.println("*************"); 
		return "redirect:/api/user/profile";
	}
}
