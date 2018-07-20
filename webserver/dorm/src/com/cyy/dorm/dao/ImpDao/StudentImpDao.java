package com.cyy.dorm.dao.ImpDao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cyy.dorm.dao.StudentDao;
import com.cyy.dorm.genericDao.genericImpDao.GenericImpDao;
import com.cyy.dorm.model.Student;

@Repository(value="StudentDao")
public class StudentImpDao extends GenericImpDao<Student,Integer>implements StudentDao{

	public List<Student> findStudentWithUsername(String username) {
		// TODO Auto-generated method stub
		String hql="from Student where username='"+username.trim()+"'";
	    List<Student> list=super.findWithHql(hql);
	    if(list!=null){
	    	return list;
	    }else{
	    	return null;
	    }
	}
	
}
