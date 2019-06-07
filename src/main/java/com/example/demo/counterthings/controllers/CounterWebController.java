package com.example.demo.counterthings.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.example.demo.counterthings.entity.Counter;
import com.example.demo.counterthings.service.CounterService;


@Controller
@RequestMapping("/counter/web")
public class CounterWebController {

	@Autowired
	private CounterService counterService;

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

	@GetMapping("/")
	public String getCounters(Model model) {
		//System.out.println("CounterService" + counterService.getAllCounters());
		model.addAttribute("counters", counterService.getAllCounters());
		return "pages/counterlist";
	}

	
	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/create" )
		public String insertCounter(HttpServletRequest request) {
			 String title = request.getParameter("title");
			 counterService.insertCounter(new Counter(title, 0));
			 return "redirect:/counter/web/";
		}

	@RequestMapping(method = {
			RequestMethod.GET,
			RequestMethod.POST
	},
			value="/delete" )
		public String deleteCounter(HttpServletRequest request) {
			String sId = request.getParameter("id");
			System.out.println("DELETE" + sId);
			int id = Integer.parseInt(sId);
			System.out.println("DELETE" + id);
			counterService.removeCounterById(id);
			System.out.println("DELETE" + id);
			return "redirect:/counter/web/";
		}

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
			 System.out.println("NEW COUNTER VALUE" + c );
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

