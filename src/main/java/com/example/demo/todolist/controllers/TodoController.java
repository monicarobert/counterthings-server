package com.example.demo.todolist.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.todolist.entity.Todo;
import com.example.demo.todolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;

	// GET sur /todo
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Todo> getAllStudents() {
		return todoService.getAllTodos();
	}

	// GET sur /todo/id 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Todo> getTodoById(@PathVariable("id") int id) {
		return todoService.getTodoById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTodoById(@PathVariable("id") int id) {
		todoService.removeTodoById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateTodoById(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertTodo(@RequestBody Todo todo) {
		todoService.insertTodo(todo);
	}
	
	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public Collection<Todo> getActiveTodo() {
		return todoService.getAllTodosActive();
	}
	
	@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)	
	public Collection<Todo> getActiveTodo(@PathVariable(value="title") String t) {
		return todoService.getTodoByTitle(t);
	}

}
