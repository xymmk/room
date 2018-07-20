package com.cyy.dorm.genericService.genericImpService;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.genericService.GenericService;


public abstract class GenericImpService<MyService,ServiceId extends Serializable> implements GenericService<MyService,ServiceId>{

	public abstract GenericDao<MyService, ServiceId> getGenericDao();
	
	public List<MyService> getWithName(String name) {
		// TODO Auto-generated method stub
		 List<MyService> list=getGenericDao().findWithName(name);
		 if(list!=null){
			 return list;
		 }else{
			 return null;
		 }
	}

	public boolean save(MyService model) {
		// TODO Auto-generated method stub
		return getGenericDao().insert(model);
	}
	public List<MyService> getWithHql(String hql){
		List<MyService> list=getGenericDao().findWithHql(hql);
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}

    public MyService checkUsernamePassword(String username,String password){
    	MyService obj=getGenericDao().findWithNamePassword(username.trim(), password.trim());
        return obj;
    }
	public boolean UpdateModel(MyService model){
		return getGenericDao().update(model);
	}
	public List<MyService> getAllByPage(int pageSize, int page){
		return getGenericDao().getAllByPage(pageSize, page);
		
	}

	public MyService findWithId(ServiceId id){
		return getGenericDao().findWithId(id);
	}

	public boolean deleteModel(ServiceId id){
		return getGenericDao().delete(id);
	
	}
}
