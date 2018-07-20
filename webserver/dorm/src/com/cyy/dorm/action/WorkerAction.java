package com.cyy.dorm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.WorkerService;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionSupport;
@Controller(value="WorkerAction")
public class WorkerAction extends ActionSupport{
	private Worker worker;
	@Resource(name="WorkerService")
	private WorkerService workerService;
	
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public WorkerService getWorkerService() {
		return workerService;
	}

	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}

	public String register(){
		System.out.println("worker name: "+worker.getUsername());
		boolean check=workerService.register(worker);
		if(check){
			return "register success";
		}else{
			return "register fail";
		}
		
	}
	public String updateWorker(){
		boolean check=workerService.updateWorker(worker);
		if(check){
			return "update success";
		}else{
			return "update fail";
		}
	}

	public String findWorker(){
		this.worker=workerService.findWithId(worker.getWorkerId());
		if(worker!=null){
		return "manager find worker";
		}else{
			return "manager not find worker";
		}
	}

	public String deleteWorker(){
		boolean check=false;
		check=workerService.deleteModel(worker.getWorkerId());
		if(check){
			return "delete worker success";
		}else{
			return "delete worker fail";
		}
	}
	public String backIndex(){
		Integer workerId=SessionDeal.getLogined("workerId");
		this.worker=workerService.findWithId(workerId);
		if(worker!=null){
			return "back success";
		}else{
			return "back fail";
		}
	}
}
