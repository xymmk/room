package com.cyy.dorm.model;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Worker")
public class Worker {
	private int workerId;
	private String name;
	private String username;
	private String password;
	private int rooms;
	
	public Worker(){}

	public Worker(String username,String password){
	    	this.username=username;
	    	this.password=password;
	    }
	public Worker(int workerId,String name,String username,String password,int rooms){
		this.workerId=workerId;
		this.name=name;
		this.username=username;
		this.password=password;
		this.rooms=rooms;
	}
	public Worker(String name,String username,String password,int rooms){
		this.name=name;
		this.username=username;
		this.password=password;
		this.rooms=rooms;
	}
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
    @Column(name="rooms",defaultValue="0")
	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	

}
