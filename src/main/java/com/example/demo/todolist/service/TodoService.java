package com.example.demo.todolist.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.todolist.dao.TodoDao;
import com.example.demo.todolist.dao.TodoDaoCrudRepo;
import com.example.demo.todolist.entity.Todo;


@Service
public class TodoService {
	@Autowired
	//@Qualifier("fakeTodoData")
	private TodoDaoCrudRepo todoDao;

	public Collection<Todo> getAllTodos(){
		return (Collection<Todo>) this.todoDao.findAll();
	}

	public Optional<Todo> getTodoById(int id){
		return this.todoDao.findById((long) id);
	}

	public void removeTodoById(int id) {
		this.todoDao.deleteById((long) id);
	} 

	public void updateTodo(Todo todo){
		((TodoDao) this.todoDao).update(todo);
	}

	public void insertTodo(Todo todo) {
		this.todoDao.save(todo);
	}
	
	public Collection<Todo> getAllTodosActive() {
		return (Collection<Todo>) this.todoDao.findByIsActiveTrue();
	}
		
	public Collection<Todo> getTodoByTitle(String t) {
		return (Collection<Todo>) this.todoDao.findByTitle(t);
	}

}
