package com.example.demo.counterthings.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.counterthings.dao.UserDaoCrudRepo;
import com.example.demo.counterthings.entity.User;

@Service
public class UserService {
	@Autowired
	//@Qualifier("fakeUserData")
	private UserDaoCrudRepo userDao;
	private Collection<User> userList = new ArrayList<>();

	public Collection<User> getAllUsers(){
		System.out.println("GETALLUSERS");
		userList=(Collection<User>) this.userDao.findAll();
		return userList;
	}

	public Optional<User> getUserById(int id){
		return this.userDao.findById((long) id);
	}

	public void removeUserById(int id) {
		this.userDao.deleteById((long) id);
	} 

	public void updateUser(User user){
		this.userDao.save(user);
	}

	public void insertUser(User user) {
		this.userDao.save(user);
	}
		
	public Collection<User> getUserByUsername(String t) {
		return (Collection<User>) this.userDao.findByUsername(t);
	}
	
    public User checkUser(String username, String pass) {
        for( User user : userList) {
    		System.out.println(user.getUsername());
    		
            if (user.getUsername() != null && user.getUsername().equals(username) &&
            		user.getPassword() != null && user.getPassword().equals(pass))
                return user;
        }
        return null;
    }
    
}
