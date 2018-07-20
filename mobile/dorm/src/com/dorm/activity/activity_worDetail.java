package com.dorm.activity;

import com.dorm.R;
import com.dorm.model.JOrder;
import com.dorm.thread.WorkerUpdateOrder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;

public class activity_worDetail  extends Activity{
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private TimePicker timePicker=null;
	private DatePicker datePicker=null;
	private EditText willFinishDate;
	private TextView msg;
	private RadioButton yes;
	private RadioGroup finish;
	private JOrder order;
	private Button sureUp,exitUp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wordetailorder);
		willFinishDate=(EditText)findViewById(R.id.willFinishDate);
		finish=(RadioGroup)findViewById(R.id.finish);
		yes=(RadioButton)findViewById(R.id.yes);
		msg=(TextView)findViewById(R.id.msg);
		sureUp=(Button)findViewById(R.id.sureUp);
		exitUp=(Button)findViewById(R.id.exitUp);
		
		order=(JOrder)(this.getIntent().getExtras().getSerializable("orderMessage"));
		msg.setText(order.getMessage());
		
		exitUp.setOnClickListener(new exitUpListener());
		sureUp.setOnClickListener(new sureUpListener());
		finish.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		    	@Override
		    	public void onCheckedChanged(RadioGroup group, int checkedId) {
		    		int radioButtonid=group.getCheckedRadioButtonId();
		    		yes=(RadioButton)activity_worDetail.this.findViewById(radioButtonid);
		    		
	                     
		    	}
		    });
		willFinishDate.setOnTouchListener(new willFinishDateListener());
	}
	private Handler handler=new Handler(){
		public void handleMessage (Message msg){
			   switch (msg.what){
			   case SERVER_ERROR:{
					Toast toast = Toast.makeText(activity_worDetail.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_worDetail.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_worDetail.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				    boolean check=(Boolean) msg.obj;
				    if(check){
						Toast toast = Toast.makeText(activity_worDetail.this, "更新成功", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }else{
						Toast toast = Toast.makeText(activity_worDetail.this, "更新失败", Toast.LENGTH_SHORT);
						toast.setMargin(0f,0.5f);
						toast.show();
				    }
			   }break;
			   }
			}
		
	};

	private class sureUpListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int i=-1;
			String willFinish=willFinishDate.getText().toString().trim();
			String fini=yes.getText().toString().trim();
			if(fini.equals("是")){
				i=1;
			}
			if(fini.equals("否")){
				i=0;
			}
//public JOrder(int orderId,int studentId,String stuName,String message,String image,String stuUsername,Integer roomId,String worUserName,Integer 
			//workerId,String uploadDate,String willFixDate,String finishDate,Integer deal){
			JOrder ord=new JOrder(order.getOrderId(),order.getStudentId(),order.getStuName(),order.getMessage(),order.getImage(),order.getStuUsername(),
					order.getRoomId(),order.getWorUserName(),order.getWorkerId(),order.getUploadDate(),willFinish.trim(),order.getFinishDate(),i);
			WorkerUpdateOrder update=new WorkerUpdateOrder(handler,ord);
			Thread a=new Thread(update);
			a.start();
		}}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private class willFinishDateListener implements OnTouchListener{

		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			if(arg1.getAction()==MotionEvent.ACTION_UP){
			CreateDialog();
		}
		    return false;
		
	}

    }
	private class exitUpListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	
			activity_worDetail.this.finish();
			
		}
		
	}
    
	
	protected void CreateDialog(){
		WindowManager m=getWindowManager();
		Display d=m.getDefaultDisplay();
		LayoutInflater flater=LayoutInflater.from(this);
		View view=flater.inflate(R.layout.activity_time,null);
		AlertDialog.Builder dialog=new AlertDialog.Builder(this);
		dialog.setView(view);
		final AlertDialog alert=dialog.create();
		Window dialogWindow=alert.getWindow();
		WindowManager.LayoutParams p=dialogWindow.getAttributes();
		p.height=(int)(d.getHeight()*0.5);
		p.width=(int)(d.getWidth()*0.6);
		dialogWindow.setAttributes(p);
		
		timePicker=(TimePicker)view.findViewById(R.id.Time);
		datePicker=(DatePicker)view.findViewById(R.id.Date);
		Button fixSure=(Button)view.findViewById(R.id.Sure);
		Button fixCancle=(Button)view.findViewById(R.id.Cancle);
		alert.setTitle("请选择时间和日期");
		fixSure.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {

				String fixHour=timePicker.getCurrentHour().toString();
				String fixMinute=timePicker.getCurrentMinute().toString();
				String fixYear=""+datePicker.getYear()+"";
				String fixMounth=""+datePicker.getMonth()+"";
				String fixDay=""+datePicker.getDayOfMonth()+"";
				willFinishDate.setText(fixYear+"-"+fixMounth+"-"+fixDay+" "+fixHour+":"+fixMinute);
				alert.cancel();
				}
		});
		fixCancle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alert.cancel();
			}
			
		});
		alert.show();
	}
}
