package com.example.demo.counterthings.controllers;

import java.util.Collection;
import java.util.Optional;

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
	
	@RequestMapping(value = "/generate", method = RequestMethod.GET, produces = "application/json")
	public String generateCounter() {
		Counter t1 = new Counter("aTest1", 0);
		Counter t2 = new Counter("zTest2", 0);
		Counter t3 = new Counter("bTest3", 0);
		Counter t4 = new Counter("dTest4", 0);

		counterService.insertCounter(t1);
		counterService.insertCounter(t2);
		counterService.insertCounter(t3);
		counterService.insertCounter(t4);
		return "{\"success\": true}";
	}

	// GET sur /counter
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Counter> getAllCounters() {
		System.out.println("getAllCounters");
		return counterService.getAllCounters();
	}

	// GET sur /counter/id 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Counter> getCounterById(@PathVariable("id") int id) {
		System.out.println("getCounterById");
		return counterService.getCounterById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCounterById(@PathVariable("id") int id) {
		System.out.println("deleteCounterById");
		counterService.removeCounterById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCounterById(@RequestBody Counter counter) {
		System.out.println("updateCounterById");
		counterService.updateCounter(counter);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertCounter(@RequestBody Counter counter) {
		System.out.println("insertCounter");
		counterService.insertCounter(counter);
	}
	
	
	@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)	
	public Collection<Counter> getActiveCounter(@PathVariable(value="title") String t) {
		System.out.println("getActiveCounter");
		return counterService.getCounterByTitle(t);
	}

}
