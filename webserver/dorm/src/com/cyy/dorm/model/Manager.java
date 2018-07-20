package com.cyy.dorm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Manager")
public class Manager {
	
	private int managerId;
	private String username;
	private String password;
	private String name;
	
	public Manager(){}
	
	public Manager(int managerId,String username,String password,String name){
		this.managerId=managerId;
		this.username=username;
		this.password=password;
		this.name=name;
	}
	public Manager(String username,String password,String name){
		this.username=username;
		this.password=password;
		this.name=name;
	}
	

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
