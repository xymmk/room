package com.cyy.dorm.service.ImpService;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyy.dorm.dao.RoomDao;
import com.cyy.dorm.dao.StudentDao;
import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.genericService.genericImpService.GenericImpService;
import com.cyy.dorm.service.*;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Room;

@Service(value="StudentService")
public class StudentImpService extends GenericImpService<Student,Integer>implements StudentService {

	@Resource(name="RoomDao")
	private RoomDao roomDao;
	@Resource(name="StudentDao")
	private StudentDao studentDao;
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public RoomDao getRoomDao() {
		return roomDao;
	}
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	@Override
	public GenericDao<Student, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return studentDao;
	}
	
	public boolean register(Student student) {
		// TODO Auto-generated method stub
		boolean check=false;
		Room room=null;
		room=roomDao.findWithId(student.getRoomId());
		List<Student> listStudent=studentDao.findStudentWithUsername(student.getUsername().trim());
		if(room!=null&&listStudent==null){
			check=super.save(student); 
		}
		return check;
	}
	public Student login(String username,String password) {
		Student stu=super.checkUsernamePassword(username.trim(),password.trim());
		return stu;
	}
	public boolean UpdateStudent(Student student) {
		// TODO Auto-generated method stub
		boolean check=false;
		Room room=null;
		room=roomDao.findWithId(student.getRoomId());
		if(room!=null){
			check=super.UpdateModel(student);
		}
		return check;
	}


}
