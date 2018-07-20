package com.cyy.dorm.dao.ImpDao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyy.dorm.dao.RoomDao;
import com.cyy.dorm.model.*;
import com.cyy.dorm.genericDao.genericImpDao.*;
@Repository(value="RoomDao")
public class RoomImpDao extends GenericImpDao<Room,Integer> implements RoomDao{

	public List<Room> getRoomNot(int pageSize, int page) {
		String hql="from Room";
		List<Room> list=super.getAllByPageWithHql(pageSize, page, hql);
		if(list.isEmpty()){
		   return null;
		}else{
			return list;
		}
	}

	public int getRoomPageNot() {
		String hql="select count(*) from Room where workerId=0";
		int pageNum=super.totalWithHql(hql);
		return pageNum;
	}



}
