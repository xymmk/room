package com.dorm.thread;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

import com.dorm.model.Student;
import com.dorm.model.Worker;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;

public class WorkerLogin implements Runnable {
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Worker worker;
	private Handler handler;
	
	public WorkerLogin(){}
    public WorkerLogin(Worker worker,Handler handler){
    	this.worker=worker;
    	this.handler=handler;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始登陆");
		String responseTis=null;
		try{
			Gson gson=new Gson();
			String json=gson.toJson(worker);
			responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/WorkerJsonAction!login","workerJson",json);
			if(responseTis!=null){
				JSONObject dataJson=new JSONObject(responseTis);
				String workerJson=dataJson.getString("workerJson");
				System.out.println(workerJson);
				Worker wor=gson.fromJson(workerJson,Worker.class);
				handler.obtainMessage(CONNECT_SUCCESS,wor).sendToTarget();
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
