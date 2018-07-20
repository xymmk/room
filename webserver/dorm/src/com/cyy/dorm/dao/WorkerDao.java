package com.cyy.dorm.dao;

import java.util.ArrayList;
import java.util.List;

import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.model.Worker;

public interface WorkerDao extends GenericDao<Worker,Integer>{
	public List<Worker> findWorkerWithUsername(String username);
	
    public List<Worker> getWorkerNot(int pageSize,int page);
    public int getWorkerPageNot();

}
