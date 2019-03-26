package com.virtusa.registrationconsumer.service;

import java.util.List;

import com.virtusa.registrationconsumer.domain.User;

public interface RegisterService {

	public void saveUser(User user);

	public User searchByEmail(String email);

	public List<User> searchByName(String name);



}
