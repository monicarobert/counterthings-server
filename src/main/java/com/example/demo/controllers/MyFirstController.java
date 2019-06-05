package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class MyFirstController {
	@GetMapping("/hello")
	@ResponseBody
	public String helloWord() {
	    return "Hello Word";
	}
	
	@GetMapping("/hello3")
	public String helloWord3() {
		return "pages/hello";
	}
	
	@GetMapping("/hello4")
	public String helloWord4(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println(name);
		return "pages/hello";
	}
	
	@GetMapping("/hello5")
	public String helloWord5(HttpServletRequest request, ModelMap map) {
		String name = request.getParameter("name");
		map.put("name", name);
		return "pages/hello";
	}
	@GetMapping("/hello6")
	public String helloWord6(@RequestParam(defaultValue="noname", required=false) String name, ModelMap map) {
		map.put("name", name);
		return "pages/hello";
	}
	
	@GetMapping(value="/hello7/{name}")
	public String helloWord7(@PathVariable(value="name") String name, ModelMap map) {
		map.put("name", name);
		return "pages/hello";
	}
}
