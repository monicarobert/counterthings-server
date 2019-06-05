package com.example.demo.counterthings.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.counterthings.entity.Counter;


@Repository
@Qualifier("fakeCounterData")
public class FakeCounterDao implements CounterDao{
	private static Map<Long, Counter> counterlist;

	static {

		counterlist = new HashMap<Long, Counter>() {

			{
				put((long) 1, new Counter(1, "Acheter du pain"));
				put((long) 2, new Counter(2, "Regarder Game of thrones"));
				put((long) 3, new Counter(3, "Installer et tester Linux"));
			}
		};
	}


	public void delete(long id) {
		counterlist.remove(id);
	}

	public void update(Counter counter) {
		counterlist.put(counter.getId(), counter);
	}

	public void save(Counter counter) {
		counterlist.put(counter.getId(), counter);
	}


	@Override
	public Collection<Counter> findAll() {
		// TODO Auto-generated method stub
		return counterlist.values();
	}

	@Override
	public Counter findOne(long id) {
		return counterlist.get(id);
	}

}
