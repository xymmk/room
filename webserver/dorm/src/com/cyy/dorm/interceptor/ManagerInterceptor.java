package com.cyy.dorm.interceptor;

import com.cyy.dorm.action.ManagerAction;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ManagerInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ManagerAction manager=(ManagerAction) arg0.getAction();
		boolean managerSession=SessionDeal.checkSession("managerId");
	     if(managerSession){
	        	
	        	return arg0.invoke();

	        }else{
	        	return "no login";
	        }
	}

}
