package com.cyy.dorm.dao.ImpDao;

import org.springframework.stereotype.Repository;

import com.cyy.dorm.dao.ManagerDao;
import com.cyy.dorm.genericDao.genericImpDao.*;
import com.cyy.dorm.model.Manager;

@Repository(value="ManagerDao")
public class ManagerImpDao extends GenericImpDao<Manager,Integer> implements ManagerDao{

}
