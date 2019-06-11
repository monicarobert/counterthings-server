package com.example.demo.counterthings.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.example.demo.counterthings.entity.Counter;
import com.example.demo.counterthings.entity.User;
import com.example.demo.counterthings.service.CounterService;
import com.example.demo.counterthings.service.UserService;

@Controller
@RequestMapping("/counter/web")
public class CounterWebController {
	
	@Autowired
	private CounterService counterService;
	private User user;

	/*
	 @RequestMapping(value = "/", method= {RequestMethod.POST, RequestMethod.GET})	
	 
	@ResponseBody
	public String insertCounter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		Counter c = new Counter(title, 0);
		System.out.println("test" + title);
		counterService.insertCounter(c);
		//response.sendRedirect("../../counters");
		return "pages/counterlist";
	}
	*/

	// SHOW COUNTERS BY USER (RETRIEVE USER FROM SESSION, PUT COUNTERS AND USER IN MODEL)
	@GetMapping("/")
	public String getCounters(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("USER");
		model.addAttribute("counters", counterService.getCountersForUser(user));
		model.addAttribute("user", user);
		return "pages/counterlist";
	}

	// GET COUNTERS BY USER (RETRIEVE COUNTERS BY USER, PUT IN MODEL CCOUNTERS AND USER
	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},	
			value="/getcountersbyuser" )
	public String getCountersByUser(HttpServletRequest request, Model model, RedirectAttributes redirAttrs, User user) {
		redirAttrs.getFlashAttributes();
		model.addAttribute("ccounters", counterService.getCountersForUser(user));
		model.addAttribute("user", user);
		return "pages/allcounterslist";
	}	
	
	// GET ALL COUNTERS
	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},	
			value="/allcounterslist" )
		public String getAllCounters(HttpServletRequest request, Model model) {
		model.addAttribute("user", null);
		model.addAttribute("ccounters", counterService.getAllCounters());
		return "pages/allcounterslist";
	}
	
	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/create" )
		public String insertCounter(HttpServletRequest request) {
			 String title = request.getParameter("title");
			 System.out.println("CREATE COUNTER " + title + user);
			 Counter c = new Counter(title, 0, user);			 
			 counterService.insertCounter(c);
			 //userService.addCounter(user,c) ;
			 System.out.println("ADDED COUNTER " + title + user);
			 
			 return "redirect:/counter/web/";
		}

/*	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/delete" )
		public String deleteCounter(HttpServletRequest request) {
			String sId = request.getParameter("id");
			int id = Integer.parseInt(sId);
			counterService.removeCounterById(id);
			return "redirect:/counter/web/";
		}
*/
	 // INCREMENT, DECREMENT COUNTERS, DELETE COUNTERS
	 @RequestMapping(method = {
			 RequestMethod.GET,
			 RequestMethod.POST
			 },
			 value="/exec" )
			 public String incrementCounter(HttpServletRequest request) {
			 int id = Integer.parseInt(request.getParameter("id"));
			 System.out.println("id sent : "+id);
			 
			 String button = request.getParameter("button");
			 System.out.println("Button:" + button);
			 
			 Counter c = counterService.getCounterById(id).orElseThrow(EntityNotFoundException::new);
			 if (button.equals("+")) // %2B in POST url
				 c.increment();
			 else if (button.equals("-"))
				 c.decrement();
			 else if (button.equals("del")) {
					counterService.removeCounterById(id);
					return "redirect:/counter/web/";
			 }
			 // System.out.println("NEW COUNTER VALUE" + c );
			 counterService.updateCounter(c);

			 return "redirect:/counter/web/";
			 }
	
	  	
	 /*	 @RequestMapping(method = {
		RequestMethod.GET,
		RequestMethod.POST
},
	 value="/exec" )
public String incrementCounter(HttpServletRequest request) {
	String title = request.getParameter("title");
	//System.out.println("TITLE= "+ title);
	//String action;
	String action= request.getParameter("action");

	//if (request.getParameter("button").equals("+"))
	//	action = "increment";
	//else action = "decrement";


	Collection<Counter> cc = counterService.getCounterByTitle(title);
	//System.out.println("!!INCREMENT!!!" + action + "title" + title + " COUNTER:" + cc);

	for (Counter c : cc) {
		if (action.equals("increment")) {
			c.increment();
		}
		else if (action.equals("decrement")) {
			c.decrement();
		}
	
		//System.out.println("NEW COUNTER VALUE" + c );
		counterService.updateCounter(c);
	}
	return "redirect:/counter/web/";
} */


}

