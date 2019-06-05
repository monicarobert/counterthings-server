package com.example.demo.counterthings.dao;

import java.util.Collection;

import com.example.demo.counterthings.entity.Counter;

// Generic DAO
public interface CounterDao {
	Collection<Counter> findAll();

	Counter findOne(long id);

	void delete(long id);

	void update(Counter c);

	void save(Counter c);

}
