package com.cyy.dorm.interceptor;


import com.cyy.dorm.action.StudentAction;
import com.cyy.dorm.util.SessionDeal;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class StudentInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入StudentInterceptor方法拦截器!!!!!!!!!!!!!"); 
		StudentAction manager=(StudentAction) arg0.getAction();
		boolean managerSession=SessionDeal.checkSession("managerId");
		boolean studentSession=SessionDeal.checkSession("studentId");
	     if(studentSession||managerSession){
	        	
	        	return arg0.invoke();

	        }else{
	        	return "no login";
	        }
	}
	}


