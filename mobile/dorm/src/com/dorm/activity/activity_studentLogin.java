package com.dorm.activity;

import java.util.List;

import com.dorm.R;
import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.thread.StudentLogin;
import com.dorm.thread.StudentRegister;
import com.dorm.unity.DataChange;
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

public class activity_studentLogin extends Activity{
	private EditText studentUsername,studentPassword;
	private Button studentLogin,studentBack;
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentlogin);
		studentUsername=(EditText)findViewById(R.id.studentUsername);
		studentPassword=(EditText)findViewById(R.id.studentPassword);
		studentLogin=(Button)findViewById(R.id.studentLogin);
		studentBack=(Button)findViewById(R.id.studentBack);
		
		studentLogin.setOnClickListener(new studentLoginListener());
		studentBack.setOnClickListener(new studentBackListener());
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
					Toast toast = Toast.makeText(activity_studentLogin.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_studentLogin.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_studentLogin.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				   Student stu=(Student) msg.obj;
				    if(stu!=null){
				    	Bundle bundle=new Bundle();
				    	bundle.putSerializable("student", stu);
				    	Intent newIntent=new Intent(activity_studentLogin.this,activity_stuCheckOrder.class);
					    newIntent.putExtras(bundle);
					    startActivity(newIntent);
				    }else{
						Toast toast = Toast.makeText(activity_studentLogin.this, "登陆失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};
	
	private class studentLoginListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String username=studentUsername.getText().toString().trim();
			String password=studentPassword.getText().toString().trim();
			String check=DataCheck.LoginCheck(username, password);
			if(check!=null){
				Toast toast = Toast.makeText(activity_studentLogin.this, check, Toast.LENGTH_SHORT);
				toast.setMargin(0f,0.5f);
				toast.show();
			}
			if(check==null){
				Student student=new Student(username,password);
				StudentLogin login= new StudentLogin(student,handler);
			    Thread a=new Thread(login);
			    a.start();
			}
			
		}
		
	}
	private class studentBackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent a=new Intent(activity_studentLogin.this,activity_choise.class);
			startActivity(a);
			activity_studentLogin.this.finish();
			
			
		}}
}
