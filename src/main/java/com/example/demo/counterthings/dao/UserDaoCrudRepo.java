package com.example.demo.counterthings.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.counterthings.entity.User;

public interface UserDaoCrudRepo extends CrudRepository<User, Long>{
	List<User> findByUsername(String username);
	User save(User user);
	void deleteById(Long id);
	void delete(User user);
	void deleteByUsername(String username);
}
