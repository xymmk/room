package com.cyy.dorm.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SessionDeal {

	   public static Map inputSession(){
			 ActionContext actionContext = ActionContext.getContext();
			 Map session = actionContext.getSession();
			 return session;
	   }
	   public static Integer getLogined(String key){
		   Map session=SessionDeal.inputSession();
		   Object userSession=session.get(key);
		   Integer id=(Integer) userSession;
		   return id;
	   }
	   
	   
	   public static boolean checkSession(String username){
		   Map session=SessionDeal.inputSession();
		   Object userSession=session.get(username);
		   /*�������session�ͷ���true*/
		   if(userSession!=null){
			   return true;
		   }/*�����ھͷ���false*/
		    else{
			   return false;
		   }
	   }
	   
	   public static boolean cleanSession()
	   {
			 ActionContext actionContext = ActionContext.getContext();
			 Map session = actionContext.getSession();
			 session.clear();
		     return true;
		   
	   }
}
