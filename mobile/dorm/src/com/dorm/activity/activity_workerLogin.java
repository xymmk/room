package com.dorm.activity;

import com.dorm.R;
import com.dorm.model.Student;
import com.dorm.model.Worker;
import com.dorm.thread.StudentLogin;
import com.dorm.thread.WorkerLogin;
import com.dorm.unity.DataCheck;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_workerLogin extends Activity {
   private final int CONNECT_SUCCESS=0;
   private final int CONNECT_FAIL=1;
   private final int SERVER_ERROR=2;
   private final int DATA_ERROR=3;
   private Button workerLogin,workerBack;
   private EditText workerPassword,workerUsername;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workerlogin);
		workerLogin=(Button)findViewById(R.id.workerLogin);
		workerBack=(Button)findViewById(R.id.workerBack);
		workerPassword=(EditText)findViewById(R.id.password);
		workerUsername=(EditText)findViewById(R.id.username);
		
		workerLogin.setOnClickListener(new workerLoginListener());
		workerBack.setOnClickListener(new workerBackListener());
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
					Toast toast = Toast.makeText(activity_workerLogin.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_workerLogin.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_workerLogin.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				   Worker wor=(Worker) msg.obj;
				    if(wor!=null){
				    	Bundle bundle=new Bundle();
				    	bundle.putSerializable("worker", wor);
				    	Intent newIntent=new Intent(activity_workerLogin.this,activity_worCheckOrder.class);
					    newIntent.putExtras(bundle);
					    startActivity(newIntent);
				    }else{
						Toast toast = Toast.makeText(activity_workerLogin.this, "登陆失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};

	private class workerLoginListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			String username=workerUsername.getText().toString().trim();
			String password=workerPassword.getText().toString().trim();
			String check=DataCheck.LoginCheck(username, password);
			if(check!=null){
				Toast toast = Toast.makeText(activity_workerLogin.this, check, Toast.LENGTH_SHORT);
				toast.setMargin(0f,0.5f);
				toast.show();
			}
			if(check==null){
				Worker worker=new Worker(username,password);
				WorkerLogin login= new WorkerLogin(worker,handler);
			    Thread a=new Thread(login);
			    a.start();
			}
			
			
		}}
	
	private class workerBackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent a=new Intent(activity_workerLogin.this,activity_choise.class);
			startActivity(a);
			activity_workerLogin.this.finish();
			
		}
		
	}
}
