package com.cyy.dorm.service.ImpService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyy.dorm.dao.WorkerDao;
import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.genericService.genericImpService.GenericImpService;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.WorkerService;

@Service(value="WorkerService")
public class WorkerImpService extends GenericImpService<Worker,Integer> implements WorkerService {

	@Resource(name="WorkerDao")
	private WorkerDao workerDao;
	
	public WorkerDao getWorkerDao() {
		return workerDao;
	}

	public void setWorkerDao(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}

	@Override
	public GenericDao<Worker, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return workerDao;
	}
	public boolean register(Worker worker){
		boolean check = false;
		worker.setRooms(0);
		List<Worker> list=workerDao.findWorkerWithUsername(worker.getUsername().trim());
		if(list==null){
			check=super.save(worker);
		}
		return check;
	}

	public Worker login(String username,String password) {
	    Worker wor=super.checkUsernamePassword(username.trim(),password.trim());
	    return wor;
	}

	public boolean updateWorker(Worker worker) {
		// TODO Auto-generated method stub
		boolean check=super.UpdateModel(worker);
		return check;
	}

}
