package com.example.demo.counterthings.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.counterthings.entity.Counter;

public interface CounterDaoCrudRepo extends CrudRepository<Counter, Long>{
	List<Counter> findByTitle(String title);
	Counter save(Counter counter);
	void deleteById(Long id);
}
