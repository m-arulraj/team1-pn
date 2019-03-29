package com.pnp.adminservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pnp.adminservice.domain.User;

@FeignClient(value = "register-user-service", path = "/api/user/registration")
public interface UsersFeignClient {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllusers();

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteByUserId(long id);

}
