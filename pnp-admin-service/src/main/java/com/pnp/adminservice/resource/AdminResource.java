package com.pnp.adminservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.adminservice.domain.Company;
import com.pnp.adminservice.domain.Post;
import com.pnp.adminservice.domain.User;
import com.pnp.adminservice.feignclient.CompanyFeignClient;
import com.pnp.adminservice.feignclient.PostFeignClient;
import com.pnp.adminservice.feignclient.UsersFeignClient;

@RestController
@RequestMapping(value = "api/admin")
public class AdminResource {

	@Autowired
	UsersFeignClient usersFeignClient;

	@Autowired
	CompanyFeignClient companyFeignClient;

	@Autowired
	PostFeignClient postFeignClient;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getlist() {
		List<User> users = null;
		users = usersFeignClient.getAllusers();
		return users;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteUserById(@PathVariable("id") long id) {

		usersFeignClient.deleteByUserId(id);
	}

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public List<Company> getAllList() {

		List<Company> companies = null;
		companies = companyFeignClient.allCompanies();
		return companies;

	}

	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	public void deleteCompanyById(@PathVariable("id") Long id) {

		companyFeignClient.deleteCompanyById(id);
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public List<Post> getAllPosts() {

		List<Post> posts = null;
		posts = postFeignClient.getAllPosts();
		return posts;

	}

	@RequestMapping(value = "/pst/{id}", method = RequestMethod.DELETE)
	public void deletePostById(@PathVariable("id") Long id) {

		postFeignClient.deletePostById(id);
	}

}
