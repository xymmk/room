package com.dorm.thread;

import java.io.File;
import java.io.IOException;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.unity.ConnectService;
import com.google.gson.Gson;

import android.os.Handler;

public class StudentUploadOrder implements Runnable {
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private boolean check=false;
	private String message;
	private int studentId;
	private Handler handler;
	private String picture=null;
    private String json=null;
    private String pictureName=null;
	public StudentUploadOrder(){};
	public StudentUploadOrder(int studentId,String message,String picture,String pictureName,Handler handler){
		this.pictureName=pictureName;
		this.studentId=studentId;
		this.message=message;
		this.handler=handler;
		this.picture=picture;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(picture!=null){
			   String path=uploadPicture();
			   uploadOrder(path);
			}else{
			   uploadOrder(null);
			}
			}catch(Exception e){
				System.out.println(e);
			}
		
	}
	
	   private String uploadOrder(String path){
		   JOrder order;
		   if(path!=null){
		   order=new JOrder(studentId,message,pictureName);
		   }else{
		   order=new JOrder(studentId,message,null);
		   }
		   String responseTis=null;
		   try{
			   Gson gson=new Gson();
			   String json=gson.toJson(order);
			   responseTis=ConnectService.connectService("http://192.168.0.100:8080/dorm/OrderJsonAction!uploadOrder","orderJson",json);
				if(responseTis!=null){
					JSONObject dataJson=new JSONObject(responseTis);
					String studentJson=dataJson.getString("orderJson");
					System.out.println(studentJson);
					this.check=gson.fromJson(studentJson,boolean.class);
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
		   return null;
	   }
	
	   private String uploadPicture() {//throws ClientProtocolException, IOException{
    	   System.out.println("开始upload picture");
    	   String backpath=null;
 	       HttpClient httpclient=new DefaultHttpClient();
 	       httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
 	       httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
 	       httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);
 	       String url="http://192.168.0.100:8080/dorm/OrderJsonAction!uploadPicture";
           HttpPost httppost=new HttpPost(url);
           File file=new File(picture);
           MultipartEntity mpEntity = new MultipartEntity();
           ContentBody cbFile = new FileBody(file);
           mpEntity.addPart("image", cbFile);
           httppost.setEntity(mpEntity);
           System.out.println("executing request " + httppost.getRequestLine());
           try{
           HttpResponse response = httpclient.execute(httppost);
           HttpEntity resEntity = response.getEntity();
           System.out.println(response.getStatusLine());//通信Ok
  
              if (resEntity != null) {
                 //System.out.println(EntityUtils.toString(resEntity,"utf-8"));
           json=EntityUtils.toString(resEntity,"utf-8");
           JSONObject p=null;
                   try{
                       p=new JSONObject(json);
                       backpath=(String) p.get("savePath");
                       System.out.println("返回图片路径"+backpath);
                   }catch(Exception e){
                       e.printStackTrace();
                   }
                 }
                 if (resEntity != null) {
                  resEntity.consumeContent();
                }
                 httpclient.getConnectionManager().shutdown();
                 return backpath;
                 }catch(ClientProtocolException e){
                	 return null;
                 }catch(IOException e){
                	 return null;
                 }
    }  

}
