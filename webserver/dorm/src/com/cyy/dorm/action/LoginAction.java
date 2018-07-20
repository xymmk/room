package com.cyy.dorm.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.cyy.dorm.model.Manager;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.ManagerService;
import com.cyy.dorm.service.StudentService;
import com.cyy.dorm.service.WorkerService;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value="LoginAction")
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private int selected;
	
	private Manager manager;
	private Student student;
	private Worker worker;
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	@Resource(name="StudentService")
	private StudentService studentService;
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Resource(name="WorkerService")
	private WorkerService workerService;
	public WorkerService getWorkerService() {
		return workerService;
	}
	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	@Resource(name="ManagerService")
	private ManagerService managerService;
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
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
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	
	public String login(){
		
		switch(selected){
		case 1:{
			this.manager=managerService.login(username, password);
			if(manager!=null){
				 Map session=SessionDeal.inputSession();
	             session.put("managerId",manager.getManagerId());
				return "manager login success";
			}else{
				return "manager login fail";
			}
		}
		case 2:{
			this.student=studentService.login(username, password);
			if(student!=null){
				System.out.println(student.getName());
				 Map session=SessionDeal.inputSession();
	             session.put("studentId",student.getStudentId());
				return "student login success";
			}else{
				return "student login fail";
			}
		}
		case 3:{
			if(selected==3){
				this.worker=workerService.login(username, password);
				if(worker!=null){
					 Map session=SessionDeal.inputSession();
		             session.put("workerId",worker.getWorkerId());
					return "worker login success";
				}else{
					return "worker login fail";
				}
			}
		}
			}
		return "login fail";
		}

}
