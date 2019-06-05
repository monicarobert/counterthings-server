package com.example.demo.todolist.dao;

import java.util.Collection;

import com.example.demo.todolist.entity.Todo;

public interface TodoDao {
	Collection<Todo> findAll();

	Todo findOne(long id);

	void delete(long id);

	void update(Todo todo);

	void save(Todo todo);

}
