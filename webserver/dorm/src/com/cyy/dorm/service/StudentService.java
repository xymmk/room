package com.cyy.dorm.service;
import java.util.List;

import com.cyy.dorm.genericService.GenericService;
import com.cyy.dorm.model.*;
public interface StudentService extends GenericService<Student,Integer> {
	public boolean register(Student student);
	public Student login(String username,String password);
	public boolean UpdateStudent(Student student);
}
