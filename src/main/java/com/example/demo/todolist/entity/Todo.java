package com.example.demo.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
     private boolean isActive;
	
	public Todo() {
	}
	
	public Todo(long id, String title) {
		this.title= title;
		this.id = id;
	}
	
	public Todo(String title, boolean isActive) {
		this.title= title;
		this.isActive = isActive;
	}
	
	public String getTitle() {
        return title;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
}
