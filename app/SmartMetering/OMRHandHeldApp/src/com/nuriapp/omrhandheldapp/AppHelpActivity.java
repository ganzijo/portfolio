package com.nuriapp.omrhandheldapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class AppHelpActivity extends Activity implements OnClickListener {

//	private ImageButton backPageBtn, settingBtn;
	private ImageButton cancelBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apphelp);

		Typeface typeFaceBody = Typeface.createFromAsset(getAssets(),"fonts/sangsang_font/SangSangBodyL.ttf");
		Typeface typeFaceHead = Typeface.createFromAsset(getAssets(),"fonts/sangsang_font/SangSangBodyM.ttf");

		// setting for action bar start
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.custom_actionbar_detailinfo, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.tv_Title);
		titleTV.setText("Smart Metering App");
		titleTV.setTextColor(Color.WHITE);
		titleTV.setTypeface(typeFaceBody);
		
		cancelBtn = (ImageButton)customView.findViewById(R.id.btn_Cancel);
		cancelBtn.setOnClickListener(this);
		
		/*backPageBtn = (ImageButton) customView.findViewById(R.id.btn_Back);
		backPageBtn.setOnClickListener(this);
		settingBtn = (ImageButton) customView.findViewById(R.id.btn_Setting);
		settingBtn.setOnClickListener(this);*/
		// setting for action bar end

		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		switch (v.getId()) {
		case R.id.btn_Cancel:
			finish();
			break;
		case R.id.btn_Setting:
			Intent Goto_Setting = new Intent(AppHelpActivity.this,SettingActivity.class);
			startActivity(Goto_Setting);
		case R.id.btn_Back:
			onBackPressed();
			break;
		}

	}

}
