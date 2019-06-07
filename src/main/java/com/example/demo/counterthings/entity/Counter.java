package com.example.demo.counterthings.entity;

	import java.awt.Color;

import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Counter {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		private String title;
	    private int count;
		
		public Counter() {
		}
		
		public Counter(long id, String title) {
			this.title= title;
			this.id = id;
		}
		
		public Counter(String title, int count) {
			this.title= title;
			this.count = count;
		}
	

		public String getTitle() {
	        return title;
	    }

	    public void setCount(int count) {
	        this.count = count;
	    }

	    public int getCount() {
	        return count;
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
	    
	    public void increment() {
	    	count++;
	    }
	    public void decrement() {
	    	count--;
	    }
	    public void reset() {
	    	count = 0;
	    }

		@Override
		public String toString() {
			return "Counter [id=" + id + ", title=" + title + ", count=" + count + "]";
		}

	}

