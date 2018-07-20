package com.cyy.dorm.interceptor;

import com.cyy.dorm.action.ManagerAction;
import com.cyy.dorm.action.OrderAction;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class OrderInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		OrderAction manager=(OrderAction) arg0.getAction();
		boolean managerSession=SessionDeal.checkSession("managerId");
		boolean studentSession=SessionDeal.checkSession("studentId");
		boolean workerSession=SessionDeal.checkSession("workerId");
	     if(managerSession||studentSession||workerSession){
	        	
	        	return arg0.invoke();

	        }else{
	        	return "no login";
	        }
	}

}
