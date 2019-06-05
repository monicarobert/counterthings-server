package com.example.demo.todolist.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.todolist.entity.Todo;

public interface TodoDaoCrudRepo extends CrudRepository<Todo, Long>{
	List<Todo> findByTitle(String title);
	List<Todo> findByIsActiveTrue();

}
