package com.dorm.activity;

import com.dorm.R;
import com.dorm.model.Student;
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


public class activity_studentRegister extends Activity{
	private EditText studentName,studentUsername,studentRoomId,studentPassword,studentSurePassword;
    private Button studentRegister,studentGoBack;
    
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studentregister);
		
		studentName=(EditText)findViewById(R.id.studentName);
		studentUsername=(EditText)findViewById(R.id.studentUsername);
		studentRoomId=(EditText)findViewById(R.id.studentRoomId);
		studentPassword=(EditText)findViewById(R.id.studentPassword);
		studentSurePassword=(EditText)findViewById(R.id.studentSurePassword);
		studentRegister=(Button)findViewById(R.id.studentRegister);
		studentGoBack=(Button)findViewById(R.id.studentGoBack);
		studentRegister.setOnClickListener(new studentRegisterListener());
		studentGoBack.setOnClickListener(new studentGoBackListener());
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
					Toast toast = Toast.makeText(activity_studentRegister.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_studentRegister.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_studentRegister.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				    boolean check=(Boolean) msg.obj;
				    if(check){
						Toast toast = Toast.makeText(activity_studentRegister.this, "注册成功", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }else{
						Toast toast = Toast.makeText(activity_studentRegister.this, "注册失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};
	private class studentRegisterListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast toast1= Toast.makeText(activity_studentRegister.this, "正在注册......", Toast.LENGTH_SHORT);
			toast1.setMargin(0f,0.5f);
			toast1.show();
			String name=studentName.getText().toString().trim();
			String username=studentUsername.getText().toString().trim();
			String password=studentPassword.getText().toString().trim();
			String surePassword=studentSurePassword.getText().toString().trim();
			String roomId=studentRoomId.getText().toString().trim();
			String check=DataCheck.StudentRegisterCheck(name, username, password, surePassword, roomId);
			if(check!=null){
				Toast toast = Toast.makeText(activity_studentRegister.this, check, Toast.LENGTH_SHORT);
				toast.setMargin(0f,0.5f);
				toast.show();
			}
			if(check==null){
				Student student=new Student(name,username,password,DataChange.StringToString(roomId));
			    StudentRegister register=new StudentRegister(student,handler);
			    Thread a=new Thread(register);
			    a.start();
			}
		}
		
	}

	private class studentGoBackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent a=new Intent(activity_studentRegister.this,activity_choise.class);
			startActivity(a);
			activity_studentRegister.this.finish();
			
		}
		
	}
}
