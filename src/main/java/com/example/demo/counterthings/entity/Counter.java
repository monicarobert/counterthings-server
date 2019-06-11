package com.example.demo.counterthings.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

	@Entity
	public class Counter {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String title;
	    private int count;
	    private String color;
	    
	    public Counter(Long id, String title, String color) {
			super();
			this.id = id;
			this.title = title;
			this.color = color;
		}

		public Counter(String title, String color) {
			super();
			this.title = title;
			this.color = color;
		}

		public Counter(String title, String color, int count) {
			super();
			this.title = title;
			this.count = count;
			this.color = color;
		}

		public Counter(Long id, String title, String color, User user) {
			super();
			this.id = id;
			this.title = title;
			this.color = color;
			this.user = user;
		}

		public Counter(String title, int count, String color, User user) {
			super();
			this.title = title;
			this.count = count;
			this.color = color;
			this.user = user;
		}

		public Counter(String title, String color, User user) {
			super();
			this.title = title;
			this.color = color;
			this.user = user;
		}

		public Counter(Long id, String title, int count, String color, User user) {
			super();
			this.id = id;
			this.title = title;
			this.count = count;
			this.color = color;
			this.user = user;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@ManyToOne
	    //(cascade = CascadeType.ALL)
	    private User user;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Counter() {
		}

		 public Counter(long id, String title) {
			this.title= title;
			this.id = id;
		} 

		public Counter(String title, int count, User user) {
			this.title= title;
			this.count = count;
			this.user = user;
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
