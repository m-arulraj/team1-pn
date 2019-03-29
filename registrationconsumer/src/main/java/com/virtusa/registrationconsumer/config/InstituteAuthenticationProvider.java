package com.virtusa.registrationconsumer.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.Role;
import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.util.EndpointConstant;

@Component
public class InstituteAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	RestTemplate template;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		String uri = EndpointConstant.USER_SERVICE_URI + "user/email/" + username;
		ResponseEntity<User> response=null;
		
		
		response= template.getForEntity(uri, User.class);
		
		User user=response.getBody();
		System.out.println(user.getEmail());
		
		/*
		 * User user = restTemplate.getForObject(EndpointConstant.REGISTER_SERVICE_URI, User.class, email);
		return user;
			response = template.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<User>() {
					});*/
		/*} catch (RestClientException e) {
			throw new BadCredentialsException("Username not found.");
		}
		if (response!=null && response.getStatusCode().value() != 200) {
			throw new BadCredentialsException("Username not found.");
		}*/
		
		if (!user.getEmail().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		
		//ResponseEntity<Role> response2=null;
		/*response2= template.getForEntity(uri+"/roles", Role.class);
		 * 
		 * */
		/*ResponseEntity<List<Role>> roleresponse = template.exchange(uri + "/roles", HttpMethod.GET, null,
		new ParameterizedTypeReference<List<Role>>() {
		});*/
		ResponseEntity<List<Role>> response2 = template.exchange(EndpointConstant.USER_SERVICE_URI + "user/email/roles",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Role>>() {
				});
		// response.getBody();
		List<Role> roles = response2.getBody();
		Collection<? extends GrantedAuthority> authorities  = roles;

		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
