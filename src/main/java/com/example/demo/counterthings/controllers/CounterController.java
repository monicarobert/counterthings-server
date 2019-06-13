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

import com.example.demo.counterthings.entity.Counter;
import com.example.demo.counterthings.service.CounterService;


@RestController
@RequestMapping("/counters")
public class CounterController {
	@Autowired
	private CounterService counterService;
	
	// Show all counters (GET in /counters)
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Counter> getAllCounters() {
		//System.out.println("getAllCounters");
		return counterService.getAllCounters();
	}
	
	// Show a counter by id (GET in /counters/?id) 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Counter> getCounterById(@PathVariable("id") int id) {
		//System.out.println("getCounterById");
		return counterService.getCounterById(id);
	}
	
	// Delete a counter by id (DELETE in /counters/?id) 
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCounterById(@PathVariable("id") int id) {
		//System.out.println("deleteCounterById");
		counterService.removeCounterById(id);
	}
	
	// Update a counter by id (PUT a counter from a Json format) 
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCounterById(@RequestBody Counter counter) {
		//System.out.println("updateCounterById");
		counterService.updateCounter(counter);
	}

	// Insert a counter (POST a counter from a Json format)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertCounter(@RequestBody Counter counter) {
		//System.out.println("insertCounter");
		counterService.insertCounter(counter);
	}
	
	
	@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)	
	public Collection<Counter> getActiveCounter(@PathVariable(value="title") String t) {
		System.out.println("getActiveCounter");
		return counterService.getCounterByTitle(t);
	}
	
}
