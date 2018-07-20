package com.cyy.dorm.dao;

import java.util.List;

import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.model.Order;


public interface OrderDao extends GenericDao<Order,Integer> {
	public List<Order> getStudentOrder(int pageSize,int page,int roomId);
    public int getStudentPageNum(int roomId);
   
    public List<Order> getWorkerOrderDeal(int pageSize,int page,int workerId);
    public int getWorkerPageNumDeal(int workerId);
    
    public List<Order> getWorkerOrderNot(int pageSize,int page,int workerId);
    public int getWorkerPageNumNot(int workerId);
    
    public List<Order> getOrderWithRoomId(int roomId);
    
    public List<Order> getOrderWithWorkerId(int workerId);
}
