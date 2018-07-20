package com.cyy.dorm.model;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Myorder")
public class Order {
	private int orderId;
	private int studentId;
	private String stuName;
	private String message;
	private String image;
	private String stuUsername;
	private Integer roomId;
	private String worUserName;
	private Integer workerId;
	private Date uploadDate;
	private Date willFixDate;
	private Date finishDate;
	private Integer deal;
	
	public Order(){}
	
	public Order(int orderId,int studentId,String stuName,String message,String image,String stuUsername,Integer roomId,String worUserName,Integer workerId,Date uploadDate,Date willFixDate,Date finishDate,Integer deal){
		this.orderId=orderId;
		this.studentId=studentId;
		this.stuName=stuName;
		this.message=message;
		this.image=image;
		this.stuUsername=stuUsername;
		this.roomId=roomId;
		this.worUserName=worUserName;
		this.workerId=workerId;
		this.uploadDate=uploadDate;
		this.willFixDate=willFixDate;
		this.finishDate=finishDate;
		this.deal=deal;
	}
	
	public Order(int studentId,String stuName,String message,String image,String stuUsername,Integer roomId,String worUserName,Integer workerId,Date uploadDate,Date willFixDate,Date finishDate,Integer deal){
		this.studentId=studentId;
		this.stuName=stuName;
		this.message=message;
		this.image=image;
		this.stuUsername=stuUsername;
		this.roomId=roomId;
		this.worUserName=worUserName;
		this.workerId=workerId;
		this.uploadDate=uploadDate;
		this.willFixDate=willFixDate;
		this.finishDate=finishDate;
		this.deal=deal;
	}
	public Order(int studentId,String stuName,String message,String stuUsername,Integer roomId,String worUserName,int workerId,Date uploadDate,Date willFixDate,Date finishDate,Integer deal){
		this.studentId=studentId;
		this.stuName=stuName;
		this.message=message;
		this.stuUsername=stuUsername;
		this.roomId=roomId;
		this.worUserName=worUserName;
		this.workerId=workerId;
		this.uploadDate=uploadDate;
		this.willFixDate=willFixDate;
		this.finishDate=finishDate;
		this.deal=deal;
	}
	
	
	   @Column(name="deal",defaultValue="0")
	public Integer getDeal() {
		return deal;
	}

	public void setDeal(Integer deal) {
		this.deal = deal;
	}

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
    @Column(name="studentId",defaultValue="0")
	public int getStudentId() {
		return studentId;
	}
    @Column(name="studentId",defaultValue="0")
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStuUsername() {
		return stuUsername;
	}
	public void setStuUsername(String stuUsername) {
		this.stuUsername = stuUsername;
	}
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getWorUserName() {
		return worUserName;
	}
	public void setWorUserName(String worUserName) {
		this.worUserName = worUserName;
	}
    @Column(name="workerId",defaultValue="0")
	public Integer getWorkerId() {
		return workerId;
	}
    @Column(name="workerId",defaultValue="0")
	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getWillFixDate() {
		return willFixDate;
	}
	public void setWillFixDate(Date willFixDate) {
		this.willFixDate = willFixDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
