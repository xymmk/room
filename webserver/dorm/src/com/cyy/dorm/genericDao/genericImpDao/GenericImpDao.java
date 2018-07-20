package com.cyy.dorm.genericDao.genericImpDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cyy.dorm.genericDao.GenericDao;


public class GenericImpDao<MyClass,Index extends Serializable> implements GenericDao<MyClass,Index> {
	

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplete")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	protected Class<?> entityClass;
	
	public GenericImpDao(){
		this.entityClass=(Class<?>)((ParameterizedType)getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("调用类的名字"+ this.entityClass);
	}

	
	public boolean insert(MyClass c) {
		hibernateTemplate.save(c);
		return true;
	}

	public boolean delete(Index id) {
	   System.out.println("传入的ID："+id);
	   Object ClassFromDatabase=hibernateTemplate.load(entityClass,id);
	   hibernateTemplate.delete(ClassFromDatabase);
	   return true;
	}
	public boolean deleteWithHql(String hql){
		System.out.println("hql语句:"+hql);
		Session session=hibernateTemplate.getSessionFactory().openSession();
		session.close();
		return false;
	}

	public boolean update(MyClass c) {
		// TODO Auto-generated method stub
		System.out.println("传入的类:"+c);
		hibernateTemplate.update(c);
		return true;
	}

	public MyClass findWithId(Index id) {
		 MyClass entity=null;
		 entity=(MyClass)hibernateTemplate.get(entityClass.getName(), id);
		 return entity;
	}

	public List<MyClass> findWithName(String str) {
	     System.out.println("entity:"+entityClass.getName());
		 String hql="from "+entityClass.getName()+" where name='"+str.trim()+"'";
	     List<MyClass> entityList=hibernateTemplate.find(hql);
	     if(entityList.isEmpty()){
	    	 return null;
	     }else{
	    	 return entityList;
	     }
	}


	public int total() {
	      Session session=hibernateTemplate.getSessionFactory().openSession();
	      String hql="select count(*) from "+entityClass.getName();
	      Query query=session.createQuery(hql);
	      int total=((Long)query.uniqueResult()).intValue();
	      session.close();
	      return total;
	      
	}

	public int totalWithHql(String hql) {
	      Session session=hibernateTemplate.getSessionFactory().openSession();
	      Query query=session.createQuery(hql);
	      int total=((Long)query.uniqueResult()).intValue();
	      session.close();
	      return total;
	}

	public List<MyClass> getAllByPage(int pageSize, int page) {
	    Session session=hibernateTemplate.getSessionFactory().openSession();
	    String hql="from "+entityClass.getName();
	    Query query=session.createQuery(hql);
	    query.setFirstResult((page-1)*pageSize);
	    query.setMaxResults(pageSize);
	    List<MyClass> list=query.list();
	    session.close();
	    return list;
	}

	public List<MyClass> getAllByPageWithHql(int pageSize, int page, String hql) {
	    Session session=hibernateTemplate.getSessionFactory().openSession();
	    Query query=session.createQuery(hql);
	    query.setFirstResult((page-1)*pageSize);
	    query.setMaxResults(pageSize);
	    List<MyClass> list=query.list();
	    session.close();
	    return list;
	}

	public List<MyClass> findWithHql(String hql) {
		// TODO Auto-generated method stub
		List<MyClass> entityList=hibernateTemplate.find(hql);
		if(entityList.isEmpty()){
			return null;
		}else{
			return entityList;
		}
	}

	public MyClass findWithNamePassword(String username, String password) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		String hql="from "+entityClass.getName()+" where username='"+username+"'and password='"+password+"'";
		//and password'"+password+"'";
		Query query=session.createQuery(hql);
		MyClass obj=(MyClass)query.uniqueResult();
		return obj;
	}
}