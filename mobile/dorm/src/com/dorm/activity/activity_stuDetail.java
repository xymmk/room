package com.dorm.activity;

import java.util.List;

import com.dorm.R;
import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.thread.StudentUpdateOrder;
import com.dorm.thread.StudentUploadOrder;
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
import android.widget.TextView;
import android.widget.Toast;

public class activity_stuDetail extends Activity{
	private JOrder order;
	private TextView msg;
	private EditText message;
	private Button sureUp ,exitUp;
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studetailord);
		msg=(TextView)findViewById(R.id.msg);
		message=(EditText)findViewById(R.id.message);
		sureUp=(Button)findViewById(R.id.sureUp);
		exitUp=(Button)findViewById(R.id.exitUp);
	    order=(JOrder)(this.getIntent().getExtras().getSerializable("orderMessage"));
	    msg.setText(order.getMessage().trim());
	    sureUp.setOnClickListener(new sureUpListener());
	    exitUp.setOnClickListener(new exitUpListener());
		System.out.println("花落去信息 "+order.getMessage());
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
					Toast toast = Toast.makeText(activity_stuDetail.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_stuDetail.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_stuDetail.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				    boolean check=(Boolean) msg.obj;
				    if(check){
						Toast toast = Toast.makeText(activity_stuDetail.this, "更新成功", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }else{
						Toast toast = Toast.makeText(activity_stuDetail.this, "更新失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};
	private class exitUpListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	
			activity_stuDetail.this.finish();
		}
		
	}
	
	private class sureUpListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String mes=message.getText().toString().trim();
			boolean check=DataCheck.objectCheck(mes);
			if(check){
			order.setMessage(mes);
			StudentUpdateOrder update=new StudentUpdateOrder(order,handler);
	        Thread server=new Thread(update);
	        server.start();
	        }else{
				Toast toast = Toast.makeText(activity_stuDetail.this, "输入内容为空", Toast.LENGTH_SHORT);
				toast.setMargin(0f,0.5f);
				toast.show();
			}
			
			
		}
		
	}

}
