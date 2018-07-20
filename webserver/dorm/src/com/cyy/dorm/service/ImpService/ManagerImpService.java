package com.cyy.dorm.service.ImpService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyy.dorm.dao.ManagerDao;
import com.cyy.dorm.dao.RoomDao;
import com.cyy.dorm.dao.StudentDao;
import com.cyy.dorm.dao.WorkerDao;

import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.genericService.genericImpService.GenericImpService;
import com.cyy.dorm.model.Manager;
import com.cyy.dorm.model.Room;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.ManagerService;
import com.cyy.dorm.util.SessionDeal;

@Service(value="ManagerService")
public class ManagerImpService extends GenericImpService<Manager,Integer> implements ManagerService {

	@Resource(name="RoomDao")
	private RoomDao roomDao;
	@Resource(name="WorkerDao")
	private WorkerDao workerDao;
	@Resource(name="StudentDao")
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public WorkerDao getWorkerDao() {
		return workerDao;
	}

	public void setWorkerDao(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	@Resource(name="ManagerDao")
    private ManagerDao managerDao;
    
	
	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public GenericDao<Manager, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return managerDao;
	}

	public Manager login(String username,String password) {
		// TODO Auto-generated method stub
		Manager man=super.checkUsernamePassword(username.trim(),password.trim());
		return man;
	}

	
	public List<Room> getRoomNot(int pageSize, int page) {
		// TODO Auto-generated method stub
		List<Room> list=roomDao.getRoomNot(pageSize, page);
		return list;
	}

	public ArrayList<Integer> getRoomPageNot() {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int pageNum=roomDao.getRoomPageNot();
		int allPage=(int)Math.ceil((double)pageNum/(double)5);
		System.out.println("获取页码  "+pageNum);
		for(int i=0;i<allPage;i++){
			list.add(i+1);
		}
		return list;
	}

	public List<Worker> getWorkerNot(int pageSize, int page) {
		// TODO Auto-generated method stub
		List<Worker> list=workerDao.getAllByPage(pageSize, page);
		return list;
	}

	public ArrayList<Integer> getWorkerPageNot() {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		int pageNum=workerDao.getWorkerPageNot();
		int allPage=(int)Math.ceil((double)pageNum/(double)5);
		System.out.println("获取页码  "+pageNum);
		for(int i=0;i<allPage;i++){
			list.add(i+1);
		}
		return list;
	}

	public boolean giveWorkerJob(int minRoom, int maxRoom, int workerId) {
		boolean check=false;
		boolean over=false;
		Worker worker=workerDao.findWithId(workerId);
		Room miRoom=roomDao.findWithId(minRoom);
		Room maRoom=roomDao.findWithId(maxRoom);
		
		int rooms=0;
		rooms=maxRoom-minRoom+1;
		if(worker!=null){
			check=true;
		}
		if(check){
		   worker.setRooms(rooms);
		}else{
			check=false;
		}
		if(check&&(miRoom!=null)&&(maRoom!=null)){
			System.out.println("分配工作");
		for(int i=minRoom;i<=maxRoom;i++){
			Room room=roomDao.findWithId(i);
			room.setWorkerId(workerId);
			room.setWorkerName(worker.getName());
			room.setWorkerUsername(worker.getUsername());
			over=roomDao.update(room);
		 }
		if(over){
			   over=workerDao.update(worker);
		  }
		}
	    return over;
	}

	public Student findStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.findWithId(studentId);
	}

	public Worker findWorker(int workerId) {
		// TODO Auto-generated method stub
		return workerDao.findWithId(workerId);
	}
	 


}
