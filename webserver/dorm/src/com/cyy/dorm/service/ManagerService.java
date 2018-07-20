package com.cyy.dorm.service;

import java.util.ArrayList;
import java.util.List;

import com.cyy.dorm.genericService.GenericService;
import com.cyy.dorm.model.Manager;
import com.cyy.dorm.model.Order;
import com.cyy.dorm.model.Room;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;

public interface ManagerService extends GenericService<Manager,Integer>{
	public Manager login(String username,String password);
	
    public List<Room> getRoomNot(int pageSize,int page);
    public ArrayList<Integer> getRoomPageNot();
    
    public List<Worker> getWorkerNot(int pageSize,int page);
    public ArrayList<Integer> getWorkerPageNot();
    
    public boolean giveWorkerJob(int minRoom,int maxRoom,int workerId);
    
    public Student findStudent(int studentId);
    
    public Worker findWorker(int workerId);
}
