package com.dorm.activity;

import com.dorm.R;
import com.dorm.model.JOrder;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class activity_worDetailn extends Activity {
	private Button exitUp;
	private TextView msg;
	private JOrder order;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wordetailordern);
		order=(JOrder)(this.getIntent().getExtras().getSerializable("orderMessage"));
		exitUp=(Button)findViewById(R.id.exitUp);
		msg=(TextView)findViewById(R.id.msg);
	    msg.setText(order.getMessage().trim());
	    exitUp.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				activity_worDetailn.this.finish();
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
