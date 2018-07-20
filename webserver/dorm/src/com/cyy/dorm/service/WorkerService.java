package com.cyy.dorm.service;

import com.cyy.dorm.genericService.GenericService;
import com.cyy.dorm.model.Worker;


public interface WorkerService extends GenericService<Worker,Integer> {
	public boolean register(Worker worker);
    public Worker login(String username,String password);
    public boolean updateWorker(Worker worker);
}
