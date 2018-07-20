package com.dorm.thread;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StudentLogin implements Runnable{
	
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Student student;
	private Student stu=null;
	private Handler handler;
	public StudentLogin(){}
	public StudentLogin(Student student,Handler handler){
		this.student=student;
		this.handler=handler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始登陆");
		String responseTis=null;
		try{
			Gson gson=new Gson();
			String json=gson.toJson(student);
			responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/StudentJsonAction!login","studentJson",json);
			if(responseTis!=null){
				JSONObject dataJson=new JSONObject(responseTis);
				String studentJson=dataJson.getString("studentJson");
				System.out.println(studentJson);
				Student stu=gson.fromJson(studentJson,Student.class);
				handler.obtainMessage(CONNECT_SUCCESS,stu).sendToTarget();
			}else{
				handler.obtainMessage(SERVER_ERROR, null).sendToTarget();
			}
		}catch(ClientProtocolException e){
			handler.obtainMessage(CONNECT_FAIL, null).sendToTarget();
			System.out.println("连接失败 "+e);
		}catch(IOException e){
			handler.obtainMessage(DATA_ERROR, null).sendToTarget();
			System.out.println("连接失败 "+e);
			
		}catch(JSONException e){
			handler.obtainMessage(DATA_ERROR, null).sendToTarget();
			System.out.println("连接失败 "+e);
		}
		
	}

}
