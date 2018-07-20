package com.cyy.dorm.action.phone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;



import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;


import com.cyy.dorm.model.JOrder;
import com.cyy.dorm.model.Worker;

import com.cyy.dorm.model.Student;
import com.cyy.dorm.service.OrderService;
import com.cyy.dorm.util.BuildPictureFile;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class OrderJsonAction extends ActionSupport{
	private String studentJson;
	private String workerJson;
	private String orderJson;
	private File image;
	private boolean check=false;
    public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	private String imageContentType;
    private String imageFileName;
    private String savePath=null;
    private String path;
	public String getStudentJson() {
		return studentJson;
	}

	public void setStudentJson(String studentJson) {
		this.studentJson = studentJson;
	}

	public String getWorkerJson() {
		return workerJson;
	}

	public void setWorkerJson(String workerJson) {
		this.workerJson = workerJson;
	}

	public String getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(String orderJson) {
		this.orderJson = orderJson;
	}
	@Resource(name="OrderService")
	private OrderService orderService;

	@JSON(serialize=false)
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public String workerCheckOrder(){
		Gson gson=new Gson();
		Worker worker=gson.fromJson(workerJson,Worker.class);
		System.out.println("获取员工姓名  "+worker.getName()+"*******");
        List<JOrder> order=orderService.getJOrderWithWorker(worker);
        if(!(order.isEmpty())){
         System.out.println("order不为空 "+order.get(0).getStuName());
         JSONArray jsonarray= JSONArray.fromObject(order);
         this.workerJson=jsonarray.toString();
         System.out.println("*********"+workerJson+"77777777777777");
        }else{
         this.workerJson=null;
        }
		return "success";
	}
	
	public String studentCheckOrder(){
		Gson gson=new Gson();
		Student student=gson.fromJson(studentJson,Student.class);
		System.out.println("获取学生姓名  "+student.getName()+"*******");
        List<JOrder> order=orderService.getJOrderWithStudent(student);
        if(!(order.isEmpty())){
         System.out.println("order不为空 "+order.get(0).getStuName());
         JSONArray jsonarray= JSONArray.fromObject(order);
         this.studentJson=jsonarray.toString();
         System.out.println("*********"+studentJson+"77777777777777");
        }else{
         this.studentJson=null;
        }
		return "success";
	}
	

	public String uploadPicture()
		    {
		   	 FileOutputStream fos=null;
		   	 FileInputStream fis=null;
		   	 try{
		   		 path=ServletActionContext.getServletContext().getRealPath("\\image");
		   		 if(BuildPictureFile.isExist(path)){
		   		 fos=new FileOutputStream(path+"\\"+getImageFileName());
		   		 fis=new FileInputStream(getImage());
		   		 byte []buffer=new byte[1024];
		   		 int len=0;
		   		 while((len=fis.read())!=-1){
		   			 fos.write(len);
		   		 }
		   		 }
		   	 }catch(Exception e){
		   		 System.out.println("fail");
		   		 e.printStackTrace();
		   	 }finally{
		   		 if(fis!=null){
		   			 try{
		   				 fis.close();
		   			 }catch(IOException e){
		   				 System.out.println("close file fail");
		   				 e.printStackTrace();
		   			 }
		   		 }
		   		 if(fos!=null){
		   			 try{
		   				 fos.close();
		   			 }catch(IOException e){
		   				 System.out.println("close file fail");
		   				 e.printStackTrace();
		   			 }
		   		 }
		   	 }
		   	 System.out.println("类型:"+imageContentType);
		   	 System.out.println("文件名:"+imageFileName);
		   	 System.out.println("savePath:"+path);
		   	 this.savePath=path+"\\"+imageFileName;
		   	 if(savePath!=null){
		   		 this.check=true;
		   	 }
				return "success";
		    }
	
	public String uploadOrder(){
		Gson gson=new Gson();
		JOrder order=gson.fromJson(orderJson, JOrder.class);
		System.out.println("获取报修单 "+order.getMessage());
		boolean check=orderService.uploadJOrder(order.getStudentId(),order.getMessage(),order.getImage());
		if(check){
			this.orderJson=gson.toJson(true);
		}else{
			this.orderJson=gson.toJson(false);
		}
		return "success";
	}

	public String updateOrder(){
		Gson gson=new Gson();
		JOrder order=gson.fromJson(orderJson, JOrder.class);
		System.out.println("获取报修单 "+order.getMessage());
		boolean check=orderService.updateJOrder(order.getOrderId(),order.getMessage());
		if(check){
			this.orderJson=gson.toJson(true);
		}else{
			this.orderJson=gson.toJson(false);
		}
		return "success";
	}
	public String workerUpOrder(){
		Gson gson=new Gson();
		JOrder order=gson.fromJson(orderJson, JOrder.class);
		System.out.println("获取报修单 "+order.getMessage());
		boolean check=orderService.workerUpdateOrder(order.getOrderId(),order.getWillFixDate(),order.getDeal());
		if(check){
			this.orderJson=gson.toJson(true);
		}else{
			this.orderJson=gson.toJson(false);
		}
		return "success";
	}
}
