package com.cyy.dorm.service;
import java.util.ArrayList;
import java.util.List;

import com.cyy.dorm.genericService.GenericService;
import com.cyy.dorm.model.JOrder;
import com.cyy.dorm.model.Order;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
public interface OrderService extends GenericService<Order,Integer> {
	public List<Order> getStudentOrder(int pageSize,int page);
    public ArrayList<Integer> getStudentPageNum();
    
    public List<Order> getWorkerOrderDeal(int pageSize,int page);
    public ArrayList<Integer> getWorkerPageNumDeal();
    
    public List<Order> getWorkerOrderNot(int pageSize,int page);
    public ArrayList<Integer> getWorkerPageNumNot();
    public boolean uploadNewOrder(String message,String image);
    
    public boolean updateDealOrder(int[] dealedOrder);
    
    public boolean bookDate(int pageSize,int page,String date);
    
    public boolean managerUpdate(Order order,String finishDate,String bookDate,int selected);
    
    public List<Order> getOrderWithStudent(Student student);
    
    public List<Order> getOrderWithWorker(Worker worker);
    
    public ArrayList<JOrder> getJOrderWithStudent(Student student);
    
    public ArrayList<JOrder> getJOrderWithWorker(Worker worker);
    
    public boolean uploadJOrder(int studentId, String message,String image);
    
    public boolean updateJOrder(int orderId,String message);

    public boolean workerUpdateOrder(int orderId,String willFix,int deal);
}
