package com.cyy.dorm.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import com.cyy.dorm.model.Manager;
import com.cyy.dorm.model.Room;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.ManagerService;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value="ManagerAction")
public class ManagerAction extends ActionSupport{

	private Manager manager;
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
	private Student student;
	private Worker worker;
	@Resource(name="ManagerService")
	private ManagerService managerService;
	
	private ArrayList<Integer> allPageRoom = new ArrayList<Integer>();
	private ArrayList<Room> arrayListRoom = new ArrayList<Room>();
	
	private ArrayList<Integer> allPageWorker = new ArrayList<Integer>();
	private ArrayList<Worker> arrayListWorker = new ArrayList<Worker>();
	private int pageRom = 1;
    private int pageWor=1;
    
    private String minRoom;
    private String maxRoom;
    private String giveWorkerId;

	public String getGiveWorkerId() {
		return giveWorkerId;
	}
	public void setGiveWorkerId(String giveWorkerId) {
		this.giveWorkerId = giveWorkerId;
	}

	public String getMinRoom() {
		return minRoom;
	}
	public void setMinRoom(String minRoom) {
		this.minRoom = minRoom;
	}
	public String getMaxRoom() {
		return maxRoom;
	}
	public void setMaxRoom(String maxRoom) {
		this.maxRoom = maxRoom;
	}
	public int getPageRom() {
		return pageRom;
	}
	public void setPageRom(int pageRom) {
		this.pageRom = pageRom;
	}
	public int getPageWor() {
		return pageWor;
	}
	public void setPageWor(int pageWor) {
		this.pageWor = pageWor;
	}
	public ArrayList<Integer> getAllPageRoom() {
		return allPageRoom;
	}
	public void setAllPageRoom(ArrayList<Integer> allPageRoom) {
		this.allPageRoom = allPageRoom;
	}
	public ArrayList<Room> getArrayListRoom() {
		return arrayListRoom;
	}
	public void setArrayListRoom(ArrayList<Room> arrayListRoom) {
		this.arrayListRoom = arrayListRoom;
	}
	public ArrayList<Integer> getAllPageWorker() {
		return allPageWorker;
	}
	public void setAllPageWorker(ArrayList<Integer> allPageWorker) {
		this.allPageWorker = allPageWorker;
	}
	public ArrayList<Worker> getArrayListWorker() {
		return arrayListWorker;
	}
	public void setArrayListWorker(ArrayList<Worker> arrayListWorker) {
		this.arrayListWorker = arrayListWorker;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}


	public String giveJob(){
		this.arrayListRoom=(ArrayList<Room>) managerService.getRoomNot(5,pageRom);
		this.allPageRoom=(ArrayList<Integer>) managerService.getRoomPageNot();
		this.arrayListWorker=(ArrayList<Worker>)managerService.getWorkerNot(5,pageWor);
		this.allPageWorker=(ArrayList<Integer>) managerService.getWorkerPageNot();
		return "check worker room";
		
	}

	public String giveWorkerJob(){
		int minRom=Integer.parseInt(minRoom);
		int maxRom=Integer.parseInt(maxRoom);
		int workerId=Integer.parseInt(giveWorkerId);
		boolean check=managerService.giveWorkerJob(minRom, maxRom, workerId);
		if(check){
			return "give job success";
		}else{
			return "give job fail";
		}
		
	}
	public String backIndex(){
		Integer managerId=SessionDeal.getLogined("managerId");
		this.manager=managerService.findWithId(managerId);
		if(manager!=null){
			return "back success";
		}else{
			return "back fail";
		}
	}


}
