package com.example.demo.todolist.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.todolist.entity.Todo;
import com.example.demo.todolist.service.TodoService;

@Controller
@RequestMapping("/todo/web")
public class TodoWebControlleur {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/hello")
	@ResponseBody
	public String helloWord() {
	    return "Hello Word";
	}
	
	@RequestMapping(value = "/", method= {RequestMethod.POST, RequestMethod.GET})	
	@ResponseBody
	public void insertTodo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		Todo t = new Todo(title, true);
		System.out.println("test" + title);
		todoService.insertTodo(t);
		response.sendRedirect("../../todos");
		//return "pages/todolist";
	}
}
