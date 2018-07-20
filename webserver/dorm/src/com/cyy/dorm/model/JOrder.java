package com.cyy.dorm.model;

import java.io.Serializable;
import java.util.Date;



public class JOrder implements Serializable {
	private int orderId;
	private int studentId;
	private String stuName;
	private String message;
	private String image;
	private String stuUsername;
	private Integer roomId;
	private String worUserName;
	private Integer workerId;
	private String uploadDate;
	private String willFixDate;
	private String finishDate;
	private Integer deal;

	
	public JOrder(){}
	private JOrder(String message){
		this.message=message;
	}
	public JOrder(int studentId,String message,String image){
		this.studentId=studentId;
		this.message=message;
		this.image=image;
	}
	public JOrder(int orderId,int studentId,String stuName,String message,String image,String stuUsername,Integer roomId,String worUserName,Integer workerId,String uploadDate,String willFixDate,String finishDate,Integer deal){
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
	
	public JOrder(int studentId,String stuName,String message,String image,String stuUsername,Integer roomId,String worUserName,Integer workerId,String uploadDate,String willFixDate,String finishDate,Integer deal){
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
	public JOrder(int studentId,String stuName,String message,String stuUsername,Integer roomId,String worUserName,int workerId,String uploadDate,String willFixDate,String finishDate,Integer deal){
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
	

	public Integer getDeal() {
		return deal;
	}

	public void setDeal(Integer deal) {
		this.deal = deal;
	}


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
    
	public int getStudentId() {
		return studentId;
	}
  
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

	public Integer getWorkerId() {
		return workerId;
	}
 
	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getWillFixDate() {
		return willFixDate;
	}
	public void setWillFixDate(String willFixDate) {
		this.willFixDate = willFixDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

}
