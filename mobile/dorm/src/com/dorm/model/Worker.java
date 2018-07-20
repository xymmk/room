package com.dorm.model;

import java.io.Serializable;




public class Worker implements Serializable {
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

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	

}
