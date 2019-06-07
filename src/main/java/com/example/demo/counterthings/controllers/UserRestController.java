package com.example.demo.counterthings.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.counterthings.entity.User;
import com.example.demo.counterthings.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/generate", method = RequestMethod.GET, produces = "application/json")
	public String generateUser() {
		User t1 = new User("R", "Monica", "monicar");
		User t2 = new User("A", "Sarah", "saraha");
		User t3 = new User("B","Alain", "alainb");
		User t4 = new User("C", "ugo", "Ugoc");

		userService.insertUser(t1);
		userService.insertUser(t2);
		userService.insertUser(t3);
		userService.insertUser(t4);
		return "{\"success\": true}";
	}

	// GET sur /users
	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> getAllUsers() {
		//System.out.println("getAllUsers");
		return userService.getAllUsers();
	}
}
