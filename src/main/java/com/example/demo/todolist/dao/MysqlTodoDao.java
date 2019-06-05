package com.example.demo.todolist.dao;

import java.util.List;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.todolist.entity.Todo;

@Transactional
	@Repository
	@Qualifier("mysqlTodoDAO")
	public class MysqlTodoDao implements TodoDao {

		@PersistenceContext
	    private EntityManager em;
		
		@Override
		public Collection<Todo> findAll() {
			List<Todo> todos = em.createQuery("SELECT t FROM Todo t").getResultList();
			return todos;
		}
		
		@Override
		public void save(Todo todo) {
			em.persist(todo);
		}

		@Override
		public Todo findOne(long id) {
			// TODO Auto-generated method stub
			Todo todo = (Todo)em.createQuery("SELECT t FROM Todo t where id=" + id).getSingleResult();
			return todo;
		}

		@Override
		public void delete(long id) {
			// TODO Auto-generated method stub
			 em.createQuery("DELETE From Todo as t where t.id = :id");
			
		}

		@Override
		public void update(Todo todo) {
			// TODO Auto-generated method stub
			
			
		}

}
