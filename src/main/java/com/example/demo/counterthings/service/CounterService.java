package com.example.demo.counterthings.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.counterthings.dao.CounterDao;
import com.example.demo.counterthings.dao.CounterDaoCrudRepo;
import com.example.demo.counterthings.entity.Counter;

@Service
public class CounterService {
	@Autowired
	//@Qualifier("fakeCounterData")
	private CounterDaoCrudRepo counterDao;

	public Collection<Counter> getAllCounters(){
		//System.out.println("GETALLCOUNTERS");
		return (Collection<Counter>) this.counterDao.findAll();
	}

	public Optional<Counter> getCounterById(int id){
		return this.counterDao.findById((long) id);
	}

	public void removeCounterById(int id) {
		this.counterDao.deleteById((long) id);
	} 

	public void updateCounter(Counter counter){
		this.counterDao.save(counter);
	}

	public void insertCounter(Counter counter) {
		this.counterDao.save(counter);
	}
		
	public Collection<Counter> getCounterByTitle(String t) {
		return (Collection<Counter>) this.counterDao.findByTitle(t);
	}

	public void removeCounterByTitle(String title) {
		// TODO Auto-generated method stub
		
	}

}

