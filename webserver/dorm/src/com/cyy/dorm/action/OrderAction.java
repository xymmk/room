package com.cyy.dorm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.cyy.dorm.model.Order;
import com.cyy.dorm.service.OrderService;
import com.cyy.dorm.util.DateTool;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "OrderAction")
public class OrderAction extends ActionSupport {
	
	private ArrayList<Integer> allPageNot=new ArrayList<Integer>();
	private ArrayList<Order> arrayListNot=new ArrayList<Order>();
    private int pageNot=1;
    private int[] dealedOrder;
	private File image = null;

	private ArrayList<Integer> allPage = new ArrayList<Integer>();
	private ArrayList<Order> arrayList = new ArrayList<Order>();
	private int page = 1;
	private Order order;
	private String bookDate;
	private String finishDate;
	private int selected;


	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public int[] getDealedOrder() {
		return dealedOrder;
	}

	public void setDealedOrder(int[] dealedOrder) {
		this.dealedOrder = dealedOrder;
	}

	public int getPageNot() {
		return pageNot;
	}

	public void setPageNot(int pageNot) {
		this.pageNot = pageNot;
	}
	public ArrayList<Integer> getAllPageNot() {
		return allPageNot;
	}

	public void setAllPageNot(ArrayList<Integer> allPageNot) {
		this.allPageNot = allPageNot;
	}

	public ArrayList<Order> getArrayListNot() {
		return arrayListNot;
	}

	public void setArrayListNot(ArrayList<Order> arrayListNot) {
		this.arrayListNot = arrayListNot;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	@Resource(name = "OrderService")
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public ArrayList<Integer> getAllPage() {
		return allPage;
	}

	public void setAllPage(ArrayList<Integer> allPage) {
		this.allPage = allPage;
	}

	public ArrayList<Order> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Order> arrayList) {
		this.arrayList = arrayList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String StudentCheckOrder() {
		this.arrayList = (ArrayList<Order>) orderService.getStudentOrder(5,
				page);
		this.allPage = (ArrayList<Integer>) orderService.getStudentPageNum();
		return "check student order";

	}

	public String uploadNewOrder() {
		boolean check = false;
		if (image != null) {
			String path = null;
			FileOutputStream fos = null;
			FileInputStream fis = null;
			try {
				path = ServletActionContext.getServletContext().getRealPath(
						"\\image");
				fos = new FileOutputStream(path + "\\" + DateTool.buildFile()
						+ ".jpg");
				fis = new FileInputStream(getImage());
				int len = 0;
				while ((len = fis.read()) != -1) {
					fos.write(len);
				}
			} catch (Exception e) {
				System.out.println("fail");
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						check = false;
						System.out.println("close file fail");
						e.printStackTrace();
					}
				}
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						check = false;
						System.out.println("close file fail");
						e.printStackTrace();
					}
				}
			}
			System.out.println("path :" + path);
			String pa=path+"\\"+DateTool.buildFile()+".jpg";
			check = orderService
					.uploadNewOrder(order.getMessage().trim(),DateTool.buildFile()+".jpg");
		} else {
			check = orderService.uploadNewOrder(order.getMessage().trim(), null);
		}
		if (check) {
			return "upload success";
		} else {
			return "upload fail";
		}
	}

	public String WorkerCheckOrder(){
		this.arrayList=(ArrayList<Order>) orderService.getWorkerOrderDeal(5,
				page);
		this.allPage=(ArrayList<Integer>) orderService.getWorkerPageNumDeal();
		this.arrayListNot=(ArrayList<Order>) orderService.getWorkerOrderNot(5,pageNot);
		this.allPageNot=(ArrayList<Integer>) orderService.getWorkerPageNumNot();
		return "check worker order";
	}

	public String dealedOrd(){
        boolean check=orderService.updateDealOrder(dealedOrder);
        if(check){
		return "add deal order";
		}else{
			return "add deal fail";
		}
	}

	public String bookDate(){
		boolean check=false;
		System.out.println("date "+bookDate);
		check=orderService.bookDate(5,pageNot,bookDate);
		if(check){
			return "all book date success";
		}else{
			return "all book date fail";
		}
	}

	
	public String findOrder(){
		this.order=orderService.findWithId(order.getOrderId());
		if(order!=null){
			return "find order success";
		}else{
			return "find order fail";
		}
	}

	public String deleteOrder(){
		boolean check=false;
		check =orderService.deleteModel(order.getOrderId());
		if(check){
			return "delete order success";
		}else{
			return "delete order fail";
		}
	}

	public String managerUpdate(){
		boolean check=false;
      check=orderService.managerUpdate(order, finishDate, bookDate, selected);
	  if(check){
		  return "manager update success";
	  }else{
		  return "manager update fail";
	  }
	}

	public String stuDetailOrder(){
		this.order=orderService.findWithId(order.getOrderId());
		if(order!=null){
			return "stu find order detail";
		}else{
			return "stu not find order detail";
		}
	}
	public String worDetailOrder(){
		this.order=orderService.findWithId(order.getOrderId());
		if(order!=null){
			return "wor find order detail";
		}else{
			return "wor not find order detail";
		}
		
	}
	public String studentUpdate(){
		boolean check=false;
		Order ord=orderService.findWithId(order.getOrderId());
		ord.setMessage(order.getMessage());
		if(ord.getDeal()==0){
		check=orderService.UpdateModel(ord);
		}
		if(check){
			return "stu update success";
		}else{
			return "stu update fail";
		}
	}
	public String workerUpdate(){
		boolean check=false;
		Order ord=orderService.findWithId(order.getOrderId());
		if(ord.getDeal()!=1){
		Date willFixDate=DateTool.SqlDateChange(bookDate);
		ord.setWillFixDate(willFixDate);
		check=orderService.UpdateModel(ord);
		if(check){
			return "wor update success";
		}else{
			return "wor update fail";
		}
		}else{
			return "wor update fail";
		}
	}
}
