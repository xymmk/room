package com.cyy.dorm.action.phone;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;


import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.WorkerService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class WorkerJsonAction extends  ActionSupport{
	@Resource(name="WorkerService")
	private WorkerService workerService;
	 @JSON(serialize=false)
	public WorkerService getWorkerService() {
		return workerService;
	}
	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}
	private String workerJson;
	public String getWorkerJson() {
		return workerJson;
	}
	public void setWorkerJson(String workerJson) {
		this.workerJson = workerJson;
	}
	public String register(){
		Gson gson=new Gson();
		Worker worker=gson.fromJson(workerJson,Worker.class);
		System.out.println("¿ªÊ¼×¢²á  "+worker.getName());
		boolean check=workerService.register(worker);
		this.workerJson=gson.toJson(check);
		return "success";
		
	}
	public String login(){
		Gson gson=new Gson();
		Worker worker=gson.fromJson(workerJson,Worker.class);
		Worker wor=workerService.checkUsernamePassword(worker.getUsername().trim(),worker.getPassword().trim());
		this.workerJson=gson.toJson(wor);
		return "success";
	}

}
