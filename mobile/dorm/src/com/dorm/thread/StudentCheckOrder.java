package com.dorm.thread;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StudentCheckOrder implements Runnable{
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Student student;
	private Handler handler;
	public StudentCheckOrder(){}
	public StudentCheckOrder(Student student,Handler handler){
		this.student=student;
		this.handler=handler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始查询");
		String responseTis=null;
		try{
			Gson gson=new Gson();
			String json=gson.toJson(student);
			responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/OrderJsonAction!studentCheckOrder","studentJson",json);
			if(responseTis!=null){
				JSONObject dataJson=new JSONObject(responseTis);
				String studentJson=dataJson.getString("studentJson");
				System.out.println("string json"+studentJson);
				//List list = (List)JSONArray.toList(jsonarray, Order.class);  
				List<JOrder> list=gson.fromJson(studentJson,new TypeToken<List<JOrder>>(){}.getType());
				handler.obtainMessage(CONNECT_SUCCESS,list).sendToTarget();
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
