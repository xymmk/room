package com.dorm.thread;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import com.dorm.model.JOrder;
import com.dorm.model.Worker;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.Handler;

public class WorkerCheckOrder  implements Runnable{
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
    private Handler handler;
    private Worker worker;
    public WorkerCheckOrder(){}
    public WorkerCheckOrder(Worker worker,Handler handler){
    	this.handler=handler;
    	this.worker=worker;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始查询");
		String responseTis=null;
		try{
			Gson gson=new Gson();
			String json=gson.toJson(worker);
			responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/OrderJsonAction!workerCheckOrder","workerJson",json);
			if(responseTis!=null){
				JSONObject dataJson=new JSONObject(responseTis);
				String workerJson=dataJson.getString("workerJson");
				System.out.println("string json"+workerJson);
				//List list = (List)JSONArray.toList(jsonarray, Order.class);  
				List<JOrder> list=gson.fromJson(workerJson,new TypeToken<List<JOrder>>(){}.getType());
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
