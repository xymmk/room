package com.cyy.dorm.dao.ImpDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyy.dorm.dao.WorkerDao;
import com.cyy.dorm.model.Room;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.genericDao.genericImpDao.GenericImpDao;

@Repository(value="WorkerDao")
public class WorkerImpDao extends GenericImpDao<Worker,Integer> implements WorkerDao{

	public List<Worker> findWorkerWithUsername(String username) {
		String hql="from Worker where username='"+username.trim()+"'";
		List<Worker> list=super.findWithHql(hql);
		if(list!=null){
			return list;
		}else{
			return null;
		}
		
	}

	public List<Worker> getWorkerNot(int pageSize, int page) {
		String hql="from Worker";
		List<Worker> list=super.getAllByPageWithHql(pageSize, page, hql);
		if(list.isEmpty()){
		   return null;
		}else{
			return list;
		}
	}

	public int getWorkerPageNot() {
		String hql="select count(*) from Worker";
		int pageNum=super.totalWithHql(hql);
		return pageNum;
	}

}
