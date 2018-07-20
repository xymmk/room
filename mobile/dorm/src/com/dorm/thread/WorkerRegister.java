package com.dorm.thread;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;


import com.dorm.model.Worker;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;

public class WorkerRegister implements Runnable{
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Worker worker;
	private Handler handler;
	private boolean check=false;
	public WorkerRegister(){}
    public WorkerRegister(Worker worker,Handler handler){
    	this.worker=worker;
    	this.handler=handler;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("��ʼע��");
		String responseTis=null;
		try{
			Gson gson=new Gson();
			String json=gson.toJson(worker);
			responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/WorkerJsonAction!register","workerJson",json);
			if(responseTis!=null){
				JSONObject dataJson=new JSONObject(responseTis);
				String workerJson=dataJson.getString("workerJson");
				System.out.println(workerJson);
				this.check=gson.fromJson(workerJson,boolean.class);
				handler.obtainMessage(CONNECT_SUCCESS,check).sendToTarget();
			}else{
				handler.obtainMessage(SERVER_ERROR, null).sendToTarget();
			}
		}catch(ClientProtocolException e){
			handler.obtainMessage(CONNECT_FAIL, null).sendToTarget();
			System.out.println("����ʧ�� "+e);
		}catch(IOException e){
			handler.obtainMessage(DATA_ERROR, null).sendToTarget();
			System.out.println("����ʧ�� "+e);
			
		}catch(JSONException e){
			handler.obtainMessage(DATA_ERROR, null).sendToTarget();
			System.out.println("����ʧ�� "+e);
		}
		
	}

}
