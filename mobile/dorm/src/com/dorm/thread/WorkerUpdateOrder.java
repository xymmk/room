package com.dorm.thread;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import com.dorm.model.JOrder;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;

import android.os.Handler;

public class WorkerUpdateOrder implements Runnable {
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Handler handler;
	private JOrder order;
	private boolean check=false;
	
	public WorkerUpdateOrder(){}
	public WorkerUpdateOrder(Handler handler,JOrder order){
		this.handler=handler;
		this.order=order;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String responseTis=null;
		try{
			Gson gson=new Gson();
			String json=gson.toJson(order);
			responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/OrderJsonAction!workerUpOrder","orderJson",json);
			if(responseTis!=null){
				JSONObject dataJson=new JSONObject(responseTis);
				String orderJson=dataJson.getString("orderJson");
				System.out.println(orderJson);
				this.check=gson.fromJson(orderJson,boolean.class);
				handler.obtainMessage(CONNECT_SUCCESS,check).sendToTarget();
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
