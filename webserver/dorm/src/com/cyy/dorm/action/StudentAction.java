package com.cyy.dorm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.cyy.dorm.model.Student;
import com.cyy.dorm.service.StudentService;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionSupport;

@Controller("StudentAction")
public class StudentAction extends ActionSupport{
	private Student student;
	
	@Resource(name="StudentService")
	private StudentService studentService;
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
    public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public String register(){
		boolean check=studentService.register(student);
		if(check){
		   return "register success";
		}else{
	       return "register fail";
		}
	}
	
	public String updateStudent(){
		System.out.println("username "+student.getUsername());
		System.out.println("name "+student.getName());
		System.out.println("password "+student.getPassword());
		System.out.println("id "+student.getStudentId());
		System.out.println("room "+student.getRoomId());
		boolean check=studentService.UpdateStudent(student);
		if(check){
			return "update success";
		}else{
			return "update fail";
		}
		
	}

	public String findStudent(){
		System.out.println("from id"+student.getStudentId());
		this.student=studentService.findWithId(student.getStudentId());
		if(student!=null){
		return "manager find student";
		}else{
			return "manager not find student";
		}
	}

	public String deleteStudent(){
		boolean check=false;
		check=studentService.deleteModel(student.getStudentId());
		if(check){
			return "delete student success";
		}else{
			return "delete student fail";
		}
	}
	public String backIndex(){
		Integer studentId=SessionDeal.getLogined("studentId");
		this.student=studentService.findWithId(studentId);
		if(student!=null){
			return "back success";
		}else{
			return "back fail";
		}
	}

}
