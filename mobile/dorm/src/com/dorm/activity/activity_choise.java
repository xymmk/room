package com.dorm.activity;

import com.dorm.R;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_choise extends Activity{
	private View activity_index,activity_login,activity_register;
	private Button choiseLogin,choiseRegister,studentLogin,workerLogin,loginBack,studentRegister,workerRegister,registerBack
	,choiseExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater =getLayoutInflater();
		activity_index=inflater.inflate(R.layout.activity_index,null);
		activity_login=inflater.inflate(R.layout.activity_choiselogin,null);
		activity_register=inflater.inflate(R.layout.activtiy_choiseregister,null);
		setContentView(activity_index);
		choiseLogin=(Button)findViewById(R.id.choiseLogin);
		choiseRegister=(Button)findViewById(R.id.choiseRegister);
		choiseExit=(Button)findViewById(R.id.choiseExit);
		choiseExit.setOnClickListener(new choiseExitListener());
		choiseLogin.setOnClickListener(new choiseLoginListener());
		choiseRegister.setOnClickListener(new choiseRegisterListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	private class choiseLoginListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			choiseLogin();
			
		}
		
	}
	
	private class choiseExitListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Intent.ACTION_MAIN);  
            intent.addCategory(Intent.CATEGORY_HOME);  
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
            startActivity(intent);  
            android.os.Process.killProcess(android.os.Process.myPid());
			
		}
		
	}

	private class choiseRegisterListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			choiseRegister();
		}
		
	}

	protected void choiseLogin(){
		setContentView(activity_login);
		studentLogin=(Button)findViewById(R.id.studentLogin);
		workerLogin=(Button)findViewById(R.id.workerLogin);
		loginBack=(Button) findViewById(R.id.loginBack);
		loginBack.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(activity_index);
				
			}});
		workerLogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent activity_workerLogin=new Intent(activity_choise.this,activity_workerLogin.class);
				startActivity(activity_workerLogin);
			}});
		studentLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent activity_studentLogin=new Intent(activity_choise.this,activity_studentLogin.class);
				 startActivity(activity_studentLogin);
			}
		}
		);
		
	}
	protected void choiseRegister(){
		setContentView(activity_register);
		studentRegister=(Button)findViewById(R.id.studentRegister);
		workerRegister=(Button)findViewById(R.id.workerRegister);
		registerBack=(Button)findViewById(R.id.registerBack);
		studentRegister.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent activity_studentRegister=new Intent(activity_choise.this,activity_studentRegister.class);
				startActivity(activity_studentRegister);
			}});
		workerRegister.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent activity_workerRegister=new Intent(activity_choise.this,activity_workerRegister.class);
				startActivity(activity_workerRegister);
				
			}});
		registerBack.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(activity_index);
				
			}});
		
	}
}
