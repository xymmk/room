package com.cyy.dorm.genericDao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<MyClass,Index extends Serializable> {

	//插入操作
	public boolean insert(MyClass c);
	//删除操作
	public boolean delete(Index id);
	//根据hql删除
	public boolean deleteWithHql(String hql);
	//更新操作
	public boolean update(MyClass c);
	//通过Id查找
	public MyClass findWithId(Index id);
	//通过用户名,数据库字段为name查找
	public List<MyClass> findWithName(String str);
	//通过HQL查找
	public List<MyClass> findWithHql(String hql);
	//统计数据表总数
	public int total();
	//传入Hql语句统计数据表总数
	public int totalWithHql(String hql);
	//分页方法
	public List<MyClass> getAllByPage(int pageSize,int page);
	//传入Hql语句的分页
	public List<MyClass> getAllByPageWithHql(int pageSize,int page,String hql);
	//根据密码和用户名查询
	public MyClass findWithNamePassword(String username,String password);
	
	
}