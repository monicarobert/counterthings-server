package com.example.demo.counterthings.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.example.demo.counterthings.entity.Counter;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	
	//@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	//(mappedBy = "user", cascade = CascadeType.ALL)
	//private List<Counter> lcounters = new ArrayList<>();
	 
	public User() {
	}
	
	public User(String username) {
		this.username= username;
	}
	
	 public User(String nom, String prenom, String username, String password) {
	     this.nom = nom;
	     this.prenom = prenom;
	     this.username = username;
	     this.password = password;
	 }
	
	 public User(String nom, String prenom, String username) {
	     this.nom = nom;
	     this.prenom = prenom;
	     this.username = username;
	 }
	 
	 public String getNom() {
	     return nom;
	 }
	
	 public void setNom(String nom) {
	     this.nom = nom;
	 }
	
	 public String getPrenom() {
	     return prenom;
	 }
	
	 public void setPrenom(String prenom) {
	     this.prenom = prenom;
	 }
	
	 public String getUsername() {
	     return username;
	 }
	
	 public void setUsername(String username) {
	     this.username = username;
	 }
	
	 public String getPassword() {
	     return password;
	 }
	
	 public void setPassword(String password) {
	     this.password = password;
	 }
	
	 @Override
	 public String toString() {
	     return "User{" + "nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", password=" + password + '}';
	 }

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

		/*public List<Counter> getLcounters() {
			return lcounters;
		}

		public void setLcounters(List<Counter> lcounters) {
			this.lcounters = lcounters;
		}
		
		public User addCounter(Counter c) {
			System.out.println("ADDCOUNTER " + c + " USER " + this);
	        this.lcounters.add(c);
	        return this;
	    } */
		


	 
	  /* public String toJSON() {
	    import com.google.gson.Gson;
	     Gson gson = new Gson();
	     return gson.toJson(this);
	 } */
}
