package com.cyy.dorm.action.phone;

import java.util.ArrayList;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.json.annotations.JSON;

import com.cyy.dorm.model.Order;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.service.OrderService;
import com.cyy.dorm.service.StudentService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class StudentJsonAction extends  ActionSupport{
	@Resource(name="OrderService")
	private OrderService orderService;
	
	 @JSON(serialize=false)
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Resource(name="StudentService")
	private StudentService studentService;
	 @JSON(serialize=false)
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	private String studentJson;

	public String getStudentJson() {
		return studentJson;
	}

	public void setStudentJson(String studentJson) {
		this.studentJson = studentJson;
	}

	public String register(){
		Gson gson=new Gson();
		Student student=gson.fromJson(studentJson,Student.class);
		System.out.println("¿ªÊ¼×¢²á  "+student.getName());
		boolean check=studentService.register(student);
		if(check){
			this.studentJson=gson.toJson(true);
		}else{
			this.studentJson=gson.toJson(false);
		}
		return "success";
	}
	public String login(){
		Gson gson=new Gson();
		Student student=gson.fromJson(studentJson,Student.class);
		Student stu=studentService.checkUsernamePassword(student.getUsername(),student.getPassword());
		this.studentJson=gson.toJson(stu);
		return "success";
	}
	public String checkOrder(){
		Gson gson=new Gson();
		Student student=gson.fromJson(studentJson,Student.class);
        ArrayList<Order> order=(ArrayList<Order>) orderService.getOrderWithStudent(student);
        JSONArray jsonarray = JSONArray.fromObject(order);
        this.studentJson=jsonarray.toString();
		return "success";
	}
	
}
