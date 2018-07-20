package com.cyy.dorm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.StudentService;
import com.cyy.dorm.service.WorkerService;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value="RegisterAction")
public class RegisterAction extends ActionSupport {
	
	private Worker worker;
	private Student student;
	
	
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@Resource(name="WorkerService")
	private WorkerService workerService;
	@Resource(name="StudentService")
	private StudentService studentService;
	public WorkerService getWorkerService() {
		return workerService;
	}
	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public String register_wor(){
		System.out.println("worker name: "+worker.getUsername());
		boolean check=workerService.register(worker);
		if(check){
			return "register success";
		}else{
			return "register fail";
		}
		
	}
	
	public String register_stu(){
		boolean check=studentService.register(student);
		if(check){
		   return "register success";
		}else{
	       return "register fail";
		}
	}

}
