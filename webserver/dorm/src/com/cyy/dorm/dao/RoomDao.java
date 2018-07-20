package com.cyy.dorm.dao;

import java.util.List;

import com.cyy.dorm.genericDao.GenericDao;

import com.cyy.dorm.model.Room;


public interface RoomDao  extends GenericDao<Room,Integer>{
    public List<Room> getRoomNot(int pageSize,int page);
    public int getRoomPageNot();

}
