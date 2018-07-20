package com.cyy.dorm.interceptor;


import com.cyy.dorm.action.WorkerAction;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class WorkerInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入WorkerInterceptor方法拦截器!!!!!!!!!!!!!"); 
		WorkerAction manager=(WorkerAction) arg0.getAction();
		boolean workerSession=SessionDeal.checkSession("workerId");
		boolean managerSession=SessionDeal.checkSession("managerId");
	     if(workerSession||managerSession){
	        	
	        	return arg0.invoke();

	        }else{
	        	return "no login";
	        }
	}

}
