package com.cyy.dorm.dao.ImpDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyy.dorm.dao.OrderDao;
import com.cyy.dorm.genericDao.genericImpDao.GenericImpDao;
import com.cyy.dorm.model.Order;

@Repository(value="OrderDao")
public class OrderImpDao extends GenericImpDao<Order,Integer> implements OrderDao{

	public List<Order> getStudentOrder(int pageSize,int page,int roomId) {
		// TODO Auto-generated method stub
		String hql="from Order where roomId='"+roomId+"'";
		List<Order> list=super.getAllByPageWithHql(pageSize, page, hql);
		if(list.isEmpty()){
		   return null;
		}else{
			return list;
		}
	}

	public int getStudentPageNum(int roomId){
		String hql="select count(*) from Order where roomId='"+roomId+"' and deal=1";
		int pageNum=super.totalWithHql(hql);
		return pageNum;
	}

	public List<Order> getWorkerOrderDeal(int pageSize,int page,int workerId){
		String hql="from Order where workerId='"+workerId+"' and deal=1";
		List<Order> list=super.getAllByPageWithHql(pageSize, page, hql);
		if(list.isEmpty()){
		   return null;
		}else{
			return list;
		}
		
	}

	public int getWorkerPageNumDeal(int workerId){
		String hql="select count(*) from Order where workerId='"+workerId+"' and deal=1";
		int pageNum=super.totalWithHql(hql);
		return pageNum;
	}

	public List<Order> getWorkerOrderNot(int pageSize, int page, int workerId) {
		String hql="from Order where workerId='"+workerId+"' and deal=0";
		List<Order> list=super.getAllByPageWithHql(pageSize, page, hql);
		if(list.isEmpty()){
		   return null;
		}else{
			return list;
		}
	}

	public int getWorkerPageNumNot(int workerId) {
		String hql="select count(*) from Order where workerId='"+workerId+"' and deal=0";
		int pageNum=super.totalWithHql(hql);
		return pageNum;
	}

	public List<Order> getOrderWithRoomId(int roomId) {
		// TODO Auto-generated method stub
		String hql="from Order where roomId='"+roomId+"'";
		List<Order> list=super.findWithHql(hql);
		return list;
	}

	public List<Order> getOrderWithWorkerId(int workerId) {
		// TODO Auto-generated method stub
		String hql="from Order where workerId='"+workerId+"'";
		List<Order> list=super.findWithHql(hql);
		return list;
	}
}
