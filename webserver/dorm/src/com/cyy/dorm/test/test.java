package com.cyy.dorm.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyy.dorm.dao.OrderDao;
import com.cyy.dorm.dao.ImpDao.StudentImpDao;
import com.cyy.dorm.model.Order;
import com.cyy.dorm.model.Student;
import com.cyy.dorm.service.OrderService;
import com.cyy.dorm.service.StudentService;
import com.cyy.dorm.service.WorkerService;
import com.cyy.dorm.service.ImpService.StudentImpService;


public class test {
	public static void main(String []args){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService dao=(OrderService)context.getBean("OrderService");
	
		//Student a=new Student("1","2","3","4");
		//dao.save(a);
		//List<Student> u=dao.getWithName("cyy");//dao.checkUsernamePassword("xymmk","123");
		//List<Student> u=dao.findWithNamePassword("xymmk","123");//("cyy");//("2");//("cyy");  
		//System.out.println(u.get(0).getName()+"************");
		  //Worker w=new Worker("1")
		  //dao.insert(u);
		//Student a=new Student(5,"yui","2","3",100);
		List<Order> b=dao.getWorkerOrderDeal(5,1);
		//ArrayList<Integer> a=new ArrayList<Integer>();
        //a=dao.getWorkerPageNumDeal();
        System.out.println(b.size());
        
	}

}
