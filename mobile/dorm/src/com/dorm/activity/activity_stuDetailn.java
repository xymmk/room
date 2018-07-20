package com.dorm.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.dorm.R;
import com.dorm.model.JOrder;

public class activity_stuDetailn extends Activity {
	private Button exitUp;
	private TextView msg;
	private JOrder order;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_studetailordn);
		msg=(TextView)findViewById(R.id.msg);
		exitUp=(Button)findViewById(R.id.exitUp);
		order=(JOrder)(this.getIntent().getExtras().getSerializable("orderMessage"));
	    msg.setText(order.getMessage().trim());
	    exitUp.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				activity_stuDetailn.this.finish();
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
