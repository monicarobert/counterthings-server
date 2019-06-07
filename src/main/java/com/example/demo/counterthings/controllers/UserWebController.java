package com.example.demo.counterthings.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.counterthings.entity.User;
import com.example.demo.counterthings.service.UserService;

@Controller
@RequestMapping("/user/web")
public class UserWebController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getCounters(Model model) {
		//model.addAttribute("users", userService.getAllUsers());
		return "pages/userlist";
	}

	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/create" )
		public String insertUser(HttpServletRequest request) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			 String username = request.getParameter("username");
			 User u1= new User(nom, prenom, username);
			 userService.insertUser(u1);
			 return "redirect:/user/web/";
	}
}

