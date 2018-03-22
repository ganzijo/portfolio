package com.nuriapp.omrhandheldapp;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MeterCollectActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meter_collection_page);
		// setting for action bar start
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.custom_actionbar, null);
		TextView titleTextView = (TextView) customView
				.findViewById(R.id.tv_Title);
		titleTextView.setText("상태");
		ImageButton backPageBtn = (ImageButton) findViewById(R.id.btn_Back);
		ImageButton settingBtn = (ImageButton) findViewById(R.id.btn_Setting);
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);
		backPageBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		settingBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//	 				Intent i = new Intent(MainActivity.this, SettingActivity.class);
				//	 				startActivity(i);
				//	 				finish();
			}
		});
		// setting for action bar end
	}

}
