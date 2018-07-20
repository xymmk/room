package com.cyy.dorm.service.ImpService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyy.dorm.model.JOrder;
import com.cyy.dorm.model.Order;
import com.cyy.dorm.model.Room;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.model.Worker;
import com.cyy.dorm.service.OrderService;
import com.cyy.dorm.util.DateTool;
import com.cyy.dorm.util.SessionDeal;
import com.cyy.dorm.dao.OrderDao;
import com.cyy.dorm.dao.RoomDao;
import com.cyy.dorm.dao.StudentDao;
import com.cyy.dorm.dao.WorkerDao;
import com.cyy.dorm.genericDao.GenericDao;
import com.cyy.dorm.genericService.genericImpService.*;

@Service(value="OrderService")
public class OrderImpService extends GenericImpService<Order,Integer>implements OrderService {

	@Resource(name="OrderDao")
	private OrderDao orderDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Resource(name="StudentDao")
	private StudentDao studentDao;
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Resource(name="RoomDao")
	private RoomDao roomDao;
	
	@Resource(name="WorkerDao")
	private WorkerDao workerDao;
	
	public RoomDao getRoomDao() {
		return roomDao;
	}
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	@Override
	public GenericDao<Order, Integer> getGenericDao() {
		// TODO Auto-generated method stub
		return orderDao;
	}
	public List<Order> getStudentOrder(int pageSize, int page) {
		Integer studentId=-1;
		studentId=SessionDeal.getLogined("studentId");
		System.out.println("学生de "+studentId);
		if(studentId!=-1){
		Student student=studentDao.findWithId(studentId);
		List<Order> list=orderDao.getStudentOrder(pageSize, page,student.getRoomId());
		return list;
		}else{
			return null;
		}
	}
	public ArrayList<Integer> getStudentPageNum() {
		// TODO Auto-generated method stub
		Integer studentId=-1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		studentId=SessionDeal.getLogined("studentId");
		System.out.println("学生de "+studentId);
		if(studentId!=-1){
		Student student=studentDao.findWithId(studentId);
		int pageNum=orderDao.getStudentPageNum(student.getRoomId());
		int allPage=(int)Math.ceil((double)pageNum/(double)5);
		System.out.println("获取页码  "+pageNum);
		for(int i=0;i<allPage;i++){
			list.add(i+1);
		}
		return list;
		}else{
			return null;
		}
	}
	
	
	
	public boolean uploadNewOrder(String message,String image) {
		// TODO Auto-generated method stub
		Integer studentId=-1;
		studentId=SessionDeal.getLogined("studentId");
		System.out.println("学生的  "+studentId);
		if(studentId!=-1){
		Student student=studentDao.findWithId(studentId);
		Room room=roomDao.findWithId(student.getRoomId());
		Order order=new Order(student.getStudentId(),student.getName(),message,image,student.getUsername(),
				student.getRoomId(),room.getWorkerUsername(),room.getWorkerId(),DateTool.getSqlDateNow(),null,null,0);
		boolean check=super.save(order);
		return check;
		}else{
			return false;
		}
	}
	
	public List<Order> getWorkerOrderDeal(int pageSize, int page) {
		// TODO Auto-generated method stub
		Integer workerId=-1;
		workerId=SessionDeal.getLogined("workerId");
		System.out.println("员工de "+workerId);
		if(workerId!=-1){
		Worker worker=workerDao.findWithId(workerId);
		List<Order> list=orderDao.getWorkerOrderDeal(pageSize, page,worker.getWorkerId());
		return list;
		}else{
			return null;
		}
	}
	public ArrayList<Integer> getWorkerPageNumDeal() {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer workerId=-1;
		workerId=SessionDeal.getLogined("workerId");
		System.out.println("员工de "+workerId);
		if(workerId!=-1){
		Worker worker=workerDao.findWithId(workerId);
		int pageNum=orderDao.getWorkerPageNumDeal(worker.getWorkerId());
		int allPage=(int)Math.ceil((double)pageNum/(double)5);
		System.out.println("获取页码  "+allPage);
		for(int i=0;i<allPage;i++){
			list.add(i+1);
		}
		return list;
		}else{
			return null;
		}
	}
	public List<Order> getWorkerOrderNot(int pageSize, int page) {
		// TODO Auto-generated method stub
		Integer workerId=-1;
		workerId=SessionDeal.getLogined("workerId");
		System.out.println("员工de "+workerId);
		if(workerId!=-1){
		Worker worker=workerDao.findWithId(workerId);
		List<Order> list=orderDao.getWorkerOrderNot(pageSize, page,worker.getWorkerId());
		return list;
		}else{
			return null;
		}
	}
	public ArrayList<Integer> getWorkerPageNumNot() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer workerId=-1;
		workerId=SessionDeal.getLogined("workerId");
		System.out.println("员工de "+workerId);
		if(workerId!=-1){
		Worker worker=workerDao.findWithId(workerId);
		int pageNum=orderDao.getWorkerPageNumNot(worker.getWorkerId());
		int allPage=(int)Math.ceil((double)pageNum/(double)5);
		System.out.println("获取页码  "+allPage);
		for(int i=0;i<allPage;i++){
			list.add(i+1);
		}
		return list;
		}else{
			return null;
		}
	}
	public boolean updateDealOrder(int[] dealedOrder) {
		boolean check=false;
		Date finishDate=DateTool.SqlDateChange(DateTool.getNow());
		for(int i=0;i<dealedOrder.length;i++){
			Order order=orderDao.findWithId(dealedOrder[i]);
			order.setFinishDate(finishDate);
			order.setDeal(1);
			check=orderDao.update(order);
		}
		return check;
	}
	public boolean bookDate(int pageSize,int page,String date) {
		// TODO Auto-generated method stub
		boolean check=false;
		Date willFixDate=(Date) DateTool.SqlDateChange(date);
		Integer workerId=-1;
		workerId=SessionDeal.getLogined("workerId");
		if(workerId!=-1){
		List<Order> order=orderDao.getWorkerOrderNot(pageSize, page, workerId);
		for(int i=0;i<order.size();i++){
			order.get(i).setWillFixDate(willFixDate);
			check=orderDao.update(order.get(i));
		}
		return check;
		}else{
			return false;
		}
	}
	public boolean managerUpdate(Order order,String finishDate,String bookDate,int selected) {
		boolean check=false;
		Order myOrder=orderDao.findWithId(order.getOrderId());
		Date willFixDate=DateTool.SqlDateChange(bookDate);
		Date finishedDate=DateTool.SqlDateChange(finishDate);
		myOrder.setWillFixDate(willFixDate);
		myOrder.setFinishDate(finishedDate);
		myOrder.setDeal(selected);
		check=orderDao.update(myOrder);
		return check;
	}
	public List<Order> getOrderWithStudent(Student student) {
		// TODO Auto-generated method stub
		Student stu=studentDao.findWithNamePassword(student.getUsername(),student.getPassword());
		List<Order> list=orderDao.getOrderWithRoomId(stu.getRoomId());
		return list;
	}
	public List<Order> getOrderWithWorker(Worker worker) {
		// TODO Auto-generated method stub
		Worker wor=workerDao.findWithNamePassword(worker.getUsername(),worker.getPassword());
		List<Order> list=orderDao.getOrderWithWorkerId(wor.getWorkerId());
		return list;
	}
	//int orderId,int studentId,String stuName,
	//String message,String image,String stuUsername,Integer roomId,
	//String worUserName,Integer workerId,String uploadDate,String willFixDate,String finishDate,Integer deal)
	public ArrayList<JOrder> getJOrderWithStudent(Student student) {
		// TODO Auto-generated method stub
		Student stu=studentDao.findWithNamePassword(student.getUsername(),student.getPassword());
		List<Order> list=orderDao.getOrderWithRoomId(stu.getRoomId());
		ArrayList<JOrder> order=new ArrayList<JOrder>();
		for(int i=0;i<list.size();i++){
	        JOrder ord=new JOrder(list.get(i).getOrderId(),list.get(i).getStudentId(),list.get(i).getStuName(),list.get(i).getMessage(),list.get(i).getImage(),
	        		list.get(i).getStuUsername(),list.get(i).getRoomId(),list.get(i).getWorUserName(),list.get(i).getWorkerId(),DateTool.DateToString(list.get(i).getUploadDate()),
	        		DateTool.DateToString(list.get(i).getWillFixDate()),DateTool.DateToString(list.get(i).getFinishDate()),list.get(i).getDeal());
	        order.add(ord);
		}
		
		return order;
	}
	public ArrayList<JOrder> getJOrderWithWorker(Worker worker) {
		// TODO Auto-generated method stub
		Worker wor=workerDao.findWithNamePassword(worker.getUsername(),worker.getPassword());
		List<Order> list=orderDao.getOrderWithWorkerId(wor.getWorkerId());
		ArrayList<JOrder> order=new ArrayList<JOrder>();
		for(int i=0;i<list.size();i++){
	        JOrder ord=new JOrder(list.get(i).getOrderId(),list.get(i).getStudentId(),list.get(i).getStuName(),list.get(i).getMessage(),list.get(i).getImage(),
	        		list.get(i).getStuUsername(),list.get(i).getRoomId(),list.get(i).getWorUserName(),list.get(i).getWorkerId(),DateTool.DateToString(list.get(i).getUploadDate()),
	        		DateTool.DateToString(list.get(i).getWillFixDate()),DateTool.DateToString(list.get(i).getFinishDate()),list.get(i).getDeal());
	        order.add(ord);
		}
		System.out.println("获取order "+list.get(0).getMessage());
		return order;
	}
	public boolean uploadJOrder(int studentId, String message, String image) {
		// TODO Auto-generated method stub
		if(studentId!=-1){
		Student student=studentDao.findWithId(studentId);
		Room room=roomDao.findWithId(student.getRoomId());
		Order order=new Order(student.getStudentId(),student.getName(),message,image,student.getUsername(),
				student.getRoomId(),room.getWorkerUsername(),room.getWorkerId(),DateTool.getSqlDateNow(),null,null,0);
		boolean check=super.save(order);
		return check;
		}else{
			return false;
		}
	}
	public boolean updateJOrder(int orderId, String message) {
		// TODO Auto-generated method stub
		boolean check=false;
		Order order=orderDao.findWithId(orderId);
		order.setMessage(message.trim());
		check=orderDao.update(order);
		return check;
	}
	public boolean workerUpdateOrder(int orderId,String willFix,int deal) {
		// TODO Auto-generated method stub
		boolean check=false;
		Order order=orderDao.findWithId(orderId);
		if(order.getDeal()==0){
		Date willFixDate=DateTool.SqlDateChangeForAndroid(willFix);
		order.setWillFixDate(willFixDate);
		order.setDeal(deal);
		if(deal==1){
			order.setFinishDate(DateTool.getSqlDateNow());
		}
		check=orderDao.update(order);
		}
		return check;
	}



}
