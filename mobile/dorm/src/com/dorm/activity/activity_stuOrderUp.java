package com.dorm.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dorm.R;
import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.thread.StudentUploadOrder;
import com.dorm.unity.DataCheck;
import com.dorm.unity.PictureDeal;

public class activity_stuOrderUp extends Activity {
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Student student;
	
	private final int TACK_PHOTO=4;
	private final int IMAGE_CODE=5;
	private final String IMAGE_TYPE = "image/*";
	
	private String fileUp=null;
	private String pictureName=null;
	
	private Button exitUp,sureUp,tackPhoto,scanPicture;
	private ImageView image=null;
	private EditText message; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		exitUp=(Button)findViewById(R.id.exitUp);
		sureUp=(Button)findViewById(R.id.sureUp);
		
		message=(EditText)findViewById(R.id.message);
		tackPhoto=(Button)findViewById(R.id.tackPhoto);
		scanPicture=(Button)findViewById(R.id.scanPicture);
		
		image=(ImageView)findViewById(R.id.image);
		
		tackPhoto.setOnClickListener(new tackPhotoListener());
		scanPicture.setOnClickListener(new scanPictureListener());
		sureUp.setOnClickListener(new sureUpListener());
		exitUp.setOnClickListener(new exitUpListener());
		student=(Student)(this.getIntent().getExtras().getSerializable("studentUp"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	private Handler handler=new Handler(){
		public void handleMessage (Message msg){
			   switch (msg.what){
			   case SERVER_ERROR:{
					Toast toast = Toast.makeText(activity_stuOrderUp.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_stuOrderUp.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_stuOrderUp.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				    boolean check=(Boolean) msg.obj;
				    if(check){
						Toast toast = Toast.makeText(activity_stuOrderUp.this, "提交成功", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }else{
						Toast toast = Toast.makeText(activity_stuOrderUp.this, "提交失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};
	

	private class sureUpListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			
    		Toast toast1 = Toast.makeText(activity_stuOrderUp.this,"上传中......", Toast.LENGTH_LONG);
			toast1.setMargin(0f,0.5f);
			toast1.show();
			System.out.println("上传");
			// TODO Auto-generated method stub
			String msg=message.getText().toString().trim();
			boolean check=DataCheck.objectCheck(msg);
			if(check){
			StudentUploadOrder upload=new StudentUploadOrder(student.getStudentId(),msg,fileUp,pictureName,handler);
	        Thread server=new Thread(upload);
	        server.start();
	        }else{
				Toast toast = Toast.makeText(activity_stuOrderUp.this, "输入内容为空", Toast.LENGTH_SHORT);
				toast.setMargin(0f,0.5f);
				toast.show();
			}
		
	}
		}
	
	private class tackPhotoListener implements OnClickListener{
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent,TACK_PHOTO);
			
		}
		
	}
	private class scanPictureListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
    		Toast toast1 = Toast.makeText(activity_stuOrderUp.this,"图片处理中......", Toast.LENGTH_LONG);
			toast1.setMargin(0f,0.5f);
			toast1.show();
			Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
			getAlbum.setType(IMAGE_TYPE);
			startActivityForResult(getAlbum, IMAGE_CODE);
			
		}
		
	}
	private class exitUpListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			 activity_stuOrderUp.this.finish();
		}
		
	}
	//*****************************************************************************图片处理**********************************************************
	protected void onActivityResult (int requestCode, int resultCode, Intent data){
		System.out.println("activity的返回结果");
		if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量
		   
		      System.out.println(resultCode);
		       return;
		   }
		Bitmap bm = null;
		//外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口

	    ContentResolver resolver = getContentResolver();

	 

	    //此处的用于判断接收的Activity是不是你想要的那个

	    if (requestCode == IMAGE_CODE) {

	        try {

	            Uri originalUri = data.getData();        //获得图片的uri 
	            bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);        //显得到bitmap图片这里开始的第二部分，获取图片的路径：
	            String[] proj = {MediaStore.Images.Media.DATA};
	            //好像是android多媒体数据库的封装接口，具体的看Android文档
	            Cursor cursor = managedQuery(originalUri, proj, null, null, null); 
	            //按我个人理解 这个是获得用户选择的图片的索引值
	            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	            //将光标移至开头 ，这个很重要，不小心很容易引起越界
	            cursor.moveToFirst();
	            //最后根据索引值获取图片路径
	            String path = cursor.getString(column_index);
	            System.out.println("图片路径 "+path+"    URI:"+originalUri.toString());
	            if(path!=null){
	            fileUp=path;
	            PictureDeal dealPicture=new PictureDeal(fileUp);
	            Thread a=new Thread(dealPicture);
	            a.start();
	        	try {
					a.join();
					System.out.println("线程暂停");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("有问题"+e);
				}
	            int getFinished=-1;
	            getFinished=dealPicture.getFinished();
	            if(getFinished==1)
	            {
	            Bitmap bitmap=dealPicture.getBitmap();
			    image.setImageBitmap(bitmap);
			    //String fileName=path;
			    String newFile[]=path.split("/");
			    int length=newFile.length-1;
			    pictureName=newFile[length];
		       System.out.println("文件名:"+pictureName);
	            }else{
	        		Toast toast = Toast.makeText(activity_stuOrderUp.this,"图片处理中", Toast.LENGTH_LONG);
					toast.setMargin(0f,0.5f);
					toast.show();
	            }
	            }else{
	        		Toast toast = Toast.makeText(activity_stuOrderUp.this,"找不到该文件路径.....", Toast.LENGTH_LONG);
					toast.setMargin(0f,0.5f);
					toast.show();
	            }
	            }catch (IOException e) {
	            	System.out.println("错误"+e); 
	            	}

	    }
		    if(requestCode == TACK_PHOTO){
		    	Bundle bundle=data.getExtras();
		    	Bitmap bitmap=(Bitmap)bundle.get("data");
		    	FileOutputStream b=null;
		    	image.setImageBitmap(bitmap);
		    	String sdStatus=Environment.getExternalStorageState();
		    	if(!sdStatus.equals(Environment.MEDIA_MOUNTED)){
		    		System.out.println("SD不可使用");
		    	}else{
		    		System.out.println("SD卡可用");
		    		File sdPath=Environment.getExternalStorageDirectory();
		    		String sdPa=sdPath.getPath();
		    		System.out.println("sd卡"+sdPa);
		    		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		    		String date=df.format(new Date());
		    		//File file=new File("/mnt/sdcard/carmer/"+date+".jpg");
		    		
		    			//file.mkdirs();
		    		pictureName=date+".jpg";
		    		fileUp=sdPa+"/"+date+".jpg";
		    		try{
		    			b=new FileOutputStream(fileUp);
		    			bitmap.compress(Bitmap.CompressFormat.JPEG,100,b);
		    		}catch(Exception e){
		    			System.out.println(e);
		    		}finally{
		    			try {
							b.flush();
							b.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println(e);
							e.printStackTrace();
						}
		    			
		    		}
		    	}
		    	
		    }

	}

}
