package com.hrms.model;


 
import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Table;
 
@Entity

@SequenceGenerator(name = "USER_MASTER_SEQ", sequenceName = "USER_MASTER_SEQ", allocationSize = 1)
 
@Table(name="USER_MASTER")
 
public class User {
 
	 @Id

	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_MASTER_SEQ")

	    private Integer id;

	    @Column(name="USERNAME")

	    private String username;

	    @Column(name="PASSWORD")

	    private String password;
 
		public Integer getId() {

			return id;

		}
 
		public void setId(Integer id) {

			this.id = id;

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

			return "User [id=" + id + ", username=" + username + ", password=" + password + "]";

		}

 
    
 
    // getters and setters

}
