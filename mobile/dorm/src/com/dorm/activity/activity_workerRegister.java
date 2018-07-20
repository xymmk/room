package com.dorm.activity;

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

import com.dorm.R;
import com.dorm.model.Student;
import com.dorm.model.Worker;
import com.dorm.thread.StudentRegister;
import com.dorm.thread.WorkerRegister;
import com.dorm.unity.DataChange;
import com.dorm.unity.DataCheck;

public class activity_workerRegister extends Activity{
	private EditText workerName,workerUsername,workerPassword,workerSurePassword;
	private Button workerRegister,workerGoBack;
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workerregister);
		workerName=(EditText)findViewById(R.id.workerName);
		workerUsername=(EditText)findViewById(R.id.workerUsername);
		workerPassword=(EditText)findViewById(R.id.workerPassword);
		workerSurePassword=(EditText)findViewById(R.id.workerSurePassword);
		
		workerRegister=(Button)findViewById(R.id.workerRegister);
		workerGoBack=(Button)findViewById(R.id.workerGoBack);
		workerRegister.setOnClickListener(new workerRegisterListener());
		workerGoBack.setOnClickListener(new workerGoBackListener());
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
					Toast toast = Toast.makeText(activity_workerRegister.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_workerRegister.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_workerRegister.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				    boolean check=(Boolean) msg.obj;
				    if(check){
						Toast toast = Toast.makeText(activity_workerRegister.this, "注册成功", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }else{
						Toast toast = Toast.makeText(activity_workerRegister.this, "注册失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};
	
	private class workerRegisterListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast toast1= Toast.makeText(activity_workerRegister.this, "正在注册......", Toast.LENGTH_SHORT);
			toast1.setMargin(0f,0.5f);
			toast1.show();
			String name=workerName.getText().toString().trim();
			String username=workerUsername.getText().toString().trim();
			String password=workerPassword.getText().toString().trim();
			String surePassword=workerSurePassword.getText().toString().trim();
			String check=DataCheck.WorkerRegister(name, username, password, surePassword);
			if(check!=null){
				Toast toast = Toast.makeText(activity_workerRegister.this, check, Toast.LENGTH_SHORT);
				toast.setMargin(0f,0.5f);
				toast.show();
			}
			if(check==null){
		        Worker worker=new Worker(name,username,password,0);
			    WorkerRegister register=new WorkerRegister(worker,handler);
			    Thread a=new Thread(register);
			    a.start();
			}
			
		}
		
	}
	private class workerGoBackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent a=new Intent(activity_workerRegister.this,activity_choise.class);
			startActivity(a);
			activity_workerRegister.this.finish();
			
			
		}
		
	}
}
