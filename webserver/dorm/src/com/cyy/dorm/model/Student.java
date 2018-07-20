package com.cyy.dorm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	private int studentId;
	private String name;
	private String username;
	private String password;
	private Integer roomId;
	
	public Student(){}
	public Student(String username,String password){
		this.username=username;
		this.password=password;
	}
	public Student(int studentId,String name,String username,String password,Integer roomId){
		this.studentId=studentId;
		this.name=name;
		this.username=username;
		this.password=password;
		this.roomId=roomId;
	
	}
	public Student(String name,String username,String password,Integer roomId){
		this.name=name;
		this.username=username;
		this.password=password;
		this.roomId=roomId;
	
	}
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}


}
