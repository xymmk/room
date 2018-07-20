package com.cyy.dorm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
	public static java.util.Date DateChange(String time){
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date date = sdf.parse(time);
			System.out.println("正确的日期格式"+date+"");
			return date;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static java.sql.Date getSqlDateNow(){
		String time=DateTool.getNow();
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	try{
    	  Date date=sdf.parse(time);
    	  java.sql.Date dateTime = new java.sql.Date(date.getTime());
    	  System.out.println("转换为 :"+dateTime+"*****");
    	  return dateTime;
      }catch(Exception e){
    	  return null;
    	  
      }
	}
	public static String getNow(){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date=df.format(new Date());
		//Date now=DateTool.DateChange(date);
		return date;
	}
    public static java.sql.Date SqlDateChange(String time){
    	SimpleDateFormat sdf =   new SimpleDateFormat("dd/MM/yyyy");
    	try{
    	  Date date=sdf.parse(time);
    	  java.sql.Date dateTime = new java.sql.Date(date.getTime());
    	  System.out.println("转换为 :"+dateTime+"*****");
    	  return dateTime;
      }catch(Exception e){
    	  return null;
    	  
      }
    	
    }
    
    public static java.sql.Date SqlDateChangeForAndroid(String time){
    	SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	try{
    	  Date date=sdf.parse(time);
    	  java.sql.Date dateTime = new java.sql.Date(date.getTime());
    	  System.out.println("转换为 :"+dateTime+"*****");
    	  return dateTime;
      }catch(Exception e){
    	  return null;
    	  
      }
    	
    }
    
    public static String DateToString(java.util.Date date){
    	if(date!=null){
    	String time="yyyy-MM-dd HH:mm:ss";
    	SimpleDateFormat sdf=new SimpleDateFormat(time);
    	String formateDate=sdf.format(date);
    	return formateDate;
    	}else{
    		return null;
    	}
    }
	public static String buildFile(){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
		String date=df.format(new Date());
		//Date now=DateTool.DateChange(date);
		return date;
	}

}
