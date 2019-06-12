package com.example.demo.counterthings.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.counterthings.entity.Counter;
import com.example.demo.counterthings.entity.User;
import com.example.demo.counterthings.service.CounterService;
import com.example.demo.counterthings.service.UserService;

@Controller
@RequestMapping("/user")
public class UserWebController
{
	@Autowired
	private UserService userService;
	private CounterService counterService;

	// USER LOGIN FORM
	@GetMapping("/")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "pages/userlogin";
	}

	// USER LOGIN SERVLET
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/login" )
	public String loginUser(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirAttrs, Model model ) throws Exception
	{
		String message = request.getParameter("message");
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	User user = userService.checkUser(username, password);
    	if (user != null)
    	{  
    		if ( user.getUsername().equals("admin@admin"))
    			return "redirect:/user/adminusers";
    
    		successLogin(request, response, user);
        	model.addAttribute(user);
    		redirAttrs.addFlashAttribute("user", user);
    		return "redirect:/counter/";
    	}
    	else
    	{
    		model.addAttribute("message", "Username or Password not recognized!");
    		redirAttrs.addFlashAttribute("message", "Username or Password not recognized!");
			//response.sendRedirect(request.getContextPath() + "/user/");
    		return "redirect:/user/";
		}
	}
	
	// SUCCESSLOGIN PROCEDURE -> SET SESSION WITH USER ATTRIBUTE
	public void successLogin(HttpServletRequest request, HttpServletResponse response, User user) throws IOException
	{
		HttpSession session = request.getSession(true);
        session.setAttribute("USER", user);
        //session.setAttribute("USERSERVICE", userService);
    }

	
	// USER CREATION FORM
	@GetMapping("/usercreation")
	public String createUsers(Model model)
	{
		return "pages/usercreate";
	}

	// USER CREATION SERVLET
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/create" )
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{		
    	String nom = request.getParameter("nom");
    	String prenom = request.getParameter("prenom");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	User u1= new User(nom, prenom, username, password);
    	userService.insertUser(u1);
		response.sendRedirect(request.getContextPath() + "/user/");
    	//return "redirect:/user";
	}
		

	// SHOW ALL USERS
	@GetMapping("/adminusers")
	public String adminUsers(Model model)
	{
		Collection<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "pages/userslist";
	}

	// DELETE USER
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/deleteuser" )
	public String deleteUser(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirAttrs, Model model) throws Exception
	{
   		String username = request.getParameter("username");
   		Collection<User> cuser = userService.getUserByUsername(username);
   		for (User user : cuser) {
   			System.out.println("DELETING USER " + username); 
   			userService.removeUser(user);
   			break;
   		}
   		/// userService.removeUserByUsername(username);
    	return "redirect:/user/adminusers";
	} 

	//SHOW COUNTERS FOR USER
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/details" )
	public String detailsUser(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirAttrs, Model model, User user) throws Exception
	{
		String username = request.getParameter("username");
		Collection<User> cuser = userService.getUserByUsername(username);

   		for (User user1 : cuser) {
   			user = user1;
   			model.addAttribute("user", user);
   	   		redirAttrs.addFlashAttribute(user);
   			break;
   		}
		
		// System.out.println("SHOWING USER DETAILS FOR " + username);
		return "redirect:/counter/getcountersbyuser";

	}
	
	//SHOW ALL COUNTERS
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value="/showallcounters" )
	public String showAllCounters(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirAttrs, Model model) throws Exception
	{
		return "redirect:/counter/allcounterslist";

	}	
	/*
 	public String failedLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
 	{
        //response.sendRedirect(request.getContextPath() + "/fail.jsp");
		return "{\"success\": false}";
    }
    */
}

