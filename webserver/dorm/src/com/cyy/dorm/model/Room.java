package com.cyy.dorm.model;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class Room {

   private int roomId;
   private int workerId;
   private String workerName;
   private String workerUsername;
   public Room(){}
   @javax.persistence.Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
    @Column(name="workerId",defaultValue="0")
	public int getWorkerId() {
		return workerId;
	}
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getWorkerUsername() {
		return workerUsername;
	}
	public void setWorkerUsername(String workerUsername) {
		this.workerUsername = workerUsername;
	}
}
