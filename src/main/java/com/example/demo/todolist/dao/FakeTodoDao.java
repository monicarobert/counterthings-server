package com.example.demo.todolist.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.todolist.entity.Todo;


@Repository
@Qualifier("fakeTodoData")
public class FakeTodoDao implements TodoDao{
	private static Map<Long, Todo> todolist;

	static {

		todolist = new HashMap<Long, Todo>() {

			{
				put((long) 1, new Todo(1, "Acheter du pain"));
				put((long) 2, new Todo(2, "Regarder Game of thrones"));
				put((long) 3, new Todo(3, "Installer et tester Linux"));
			}
		};
	}


	public void delete(long id) {
		todolist.remove(id);
	}

	public void update(Todo todo) {
		todolist.put(todo.getId(), todo);
	}

	public void save(Todo todo) {
		todolist.put(todo.getId(), todo);
	}


	@Override
	public Collection<Todo> findAll() {
		// TODO Auto-generated method stub
		return todolist.values();
	}

	@Override
	public Todo findOne(long id) {
		return todolist.get(id);
	}
}
