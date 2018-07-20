package com.dorm.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dorm.R;
import com.dorm.model.JOrder;
import com.dorm.model.Student;
import com.dorm.thread.StudentCheckOrder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class activity_stuCheckOrder extends Activity{
	private  List<JOrder>  myOrder;
	private final int CONNECT_SUCCESS=0;
	private final int CONNECT_FAIL=1;
	private final int SERVER_ERROR=2;
	private final int DATA_ERROR=3;
	private Button studentOrder,studentBack;
	private ListView  studentList;
	private Student stu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkorderstu);
		studentOrder=(Button)findViewById(R.id.studentOrder);
		studentBack=(Button)findViewById(R.id.studentBack);
		studentList=(ListView)findViewById(R.id.studentList);
		Student student=(Student)(this.getIntent().getExtras().getSerializable("student"));
		stu=student;
		System.out.println("学生姓名 "+student.getName());
		StudentCheckOrder checkOrder=new StudentCheckOrder(student,handler);
		Thread a=new Thread(checkOrder);
		a.start();
		
		studentOrder.setOnClickListener(new studentOrderListener());
		studentBack.setOnClickListener(new studentBackListener());
		studentList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				      int deal=myOrder.get(arg2).getDeal();
				      if(deal==0){
				      Bundle bundle=new Bundle();
				      bundle.putSerializable("orderMessage",myOrder.get(arg2));
				      Intent newIntent=new Intent(activity_stuCheckOrder.this,activity_stuDetail.class);
					  newIntent.putExtras(bundle);
					  startActivity(newIntent);
					  }
				      if(deal==1){
					      Bundle bundle=new Bundle();
					      bundle.putSerializable("orderMessage",myOrder.get(arg2));
					      Intent newIntent=new Intent(activity_stuCheckOrder.this,activity_stuDetailn.class);
						  newIntent.putExtras(bundle);
						  startActivity(newIntent);
				      }
			}});
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
					Toast toast = Toast.makeText(activity_stuCheckOrder.this, "服务器连接出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_FAIL:{
					Toast toast = Toast.makeText(activity_stuCheckOrder.this, "连接服务器失败", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case DATA_ERROR:{
					Toast toast = Toast.makeText(activity_stuCheckOrder.this, "数据流出错", Toast.LENGTH_SHORT);
					toast.setMargin(0f,0.5f);
					toast.show();
			   }break;
			   case CONNECT_SUCCESS:{
				    List<JOrder> list=(List<JOrder>)msg.obj;
				    myOrder=list;
				    ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
				    for(int i=0;i<list.size();i++){
				    	HashMap<String,Object> map=new HashMap<String,Object>();
				    	map.put("orderId",list.get(i).getOrderId());
				    	map.put("roomId",list.get(i).getRoomId());
				    	map.put("studentId",list.get(i).getStudentId());
				    	map.put("workerId",list.get(i).getWorkerId());
				    	map.put("uploadDate",list.get(i).getUploadDate());
				    	map.put("willFixDate",list.get(i).getWillFixDate());
				    	map.put("finishDate",list.get(i).getFinishDate());
				    	String deal=null;
						if(list.get(i).getDeal()==0){
							deal="否";
						}else{
							deal="是";
						}
						map.put("deal",deal);
						listItem.add(map);
				    }
					SimpleAdapter  mSimpleAdapter=new SimpleAdapter (activity_stuCheckOrder.this,
							listItem,
							R.layout.activity_listitemr,
							new String[]{"orderId","roomId","studentId","workerId","uploadDate","willFixDate","finishDate","deal"},
							new int[]{R.id.orderId,R.id.roomId,R.id.studentId,R.id.workerId,R.id.uploadDate,R.id.willFixDate,R.id.finishDate,R.id.deal});
					studentList.setAdapter(mSimpleAdapter); 
			   }break;
			   }
			}
		
	};

	private class studentOrderListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		      Bundle bundle=new Bundle();
		      bundle.putSerializable("studentUp",stu);
		      Intent newIntent=new Intent(activity_stuCheckOrder.this,activity_stuOrderUp.class);
			  newIntent.putExtras(bundle);
			  startActivity(newIntent);
		}
		
	}
	private class studentBackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent a=new Intent(activity_stuCheckOrder.this,activity_studentLogin.class);
			startActivity(a);
			activity_stuCheckOrder.this.finish();
			
			
		}
		
	}


}
