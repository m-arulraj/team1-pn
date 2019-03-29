package com.pnp.adminservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.adminservice.domain.User;
import com.pnp.adminservice.feignclient.UsersFeignClient;

@RestController
public class AdminResource {

	/*@Autowired
	AdminService adminService;*/

	@Autowired
	UsersFeignClient usersFeignClient;

	@RequestMapping(value = "api/users", method = RequestMethod.GET)
	public List<User> getlist() {
		System.out.println("*************************");
		List<User> users = null;
		users = usersFeignClient.getAllusers();
		return users;
	}

}
