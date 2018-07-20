package com.dorm.unity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;



import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class ConnectService {
	public static String connectService(String link,String name,String pagram)throws ClientProtocolException, IOException{
		System.out.println("��������");
		String param=null;
		String n=null;
		param=pagram;
		String url=link;
		HttpPost httpPost=new HttpPost(url);
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(name,param));
		HttpResponse httpResponse=null;
		httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);//��������ʱ
		defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000); //�����ȡ��ʱ
		httpResponse = defaultHttpClient.execute(httpPost);
		System.out.println("����android_servlet״̬"+httpResponse.getStatusLine().getStatusCode());
		if(httpResponse.getStatusLine().getStatusCode()==200){
	    	n=EntityUtils.toString(httpResponse.getEntity());
	    	System.out.println("����json"+n);
 
	    	return n;
	       }else{
	    	 return null;
	       }
	}
	public static String testService(String link,String name,String pa){
		System.out.println("��������");
		String param=null;
		param=pa;
		String n=null;
		//String url="http://jetpm.vicp.net:8088/androidTest/UserAction!login";//����x
		String url=link;
		HttpPost httpPost=new HttpPost(url);
		Gson gson=new Gson();
    	List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(name,param));
		HttpResponse httpResponse=null;
		    try {
				httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
			defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);//��������ʱ
			defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000); //�����ȡ��ʱ
			try {
				httpResponse = defaultHttpClient.execute(httpPost);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				System.out.println("����"+e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("����"+e);
			} 
	        System.out.println("����android_servlet״̬"+httpResponse.getStatusLine().getStatusCode()); 
	       if(httpResponse.getStatusLine().getStatusCode()==200){
	    	try {
				n=EntityUtils.toString(httpResponse.getEntity());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("����"+e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("����"+e);
			}
	    	System.out.println("����json"+n);
 
	    	return n;
	       }else{
	    	 return null;
	       }
	}

}
