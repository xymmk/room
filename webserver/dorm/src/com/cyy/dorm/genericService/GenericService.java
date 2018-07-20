package com.cyy.dorm.genericService;

import java.io.Serializable;
import java.util.List;

public interface GenericService<MyService,ServiceIndex extends Serializable> {

	public List<MyService> getWithName(String name);
	public boolean save(MyService model);
	public List<MyService> getWithHql(String hql);
	public MyService checkUsernamePassword(String username,String password);
	public boolean UpdateModel(MyService model);
	public List<MyService> getAllByPage(int pageSize, int page);
	public MyService findWithId(ServiceIndex id);
	public boolean deleteModel(ServiceIndex id);
}
