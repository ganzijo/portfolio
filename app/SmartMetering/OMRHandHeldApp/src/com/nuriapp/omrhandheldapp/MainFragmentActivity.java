package com.nuriapp.omrhandheldapp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.nuriapp.server.GetDataFromServer;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainFragmentActivity extends FragmentActivity implements OnClickListener {

	private FragmentTabHost fragmentTabHost;
	private ImageButton backPageBtn, settingBtn;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tab_page);

		Typeface typeFaceBody = Typeface.createFromAsset(getAssets(),
				"fonts/sangsang_font/SangSangBodyL.ttf");
		Typeface typeFaceHead = Typeface.createFromAsset(getAssets(),
				"fonts/sangsang_font/SangSangBodyM.ttf");
		

		// setting for action bar start
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.custom_actionbar, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.tv_Title);
		titleTV.setText("Smart Metering App");
		titleTV.setTextColor(Color.WHITE);
		titleTV.setTypeface(typeFaceBody);
		backPageBtn = (ImageButton) customView.findViewById(R.id.btn_Back);
		settingBtn = (ImageButton) customView.findViewById(R.id.btn_Setting);
		settingBtn.setOnClickListener(this);
		backPageBtn.setOnClickListener(this);
		
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);
		// setting for action bar end

		// Setting Main Tab
		fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		fragmentTabHost.setup(this, getSupportFragmentManager(),
				android.R.id.tabcontent);
		fragmentTabHost.addTab(fragmentTabHost.newTabSpec("ReadListFragment")
				.setIndicator("검침대상 목록"), ReadListFragment.class, null);
		fragmentTabHost.addTab(fragmentTabHost
				.newTabSpec("ReadStorageFragment").setIndicator("검침 보관함"),
				ReadStorageFragment.class, null);


		// setting for tabwidget start
		for (int i = 0; i < fragmentTabHost.getTabWidget().getChildCount(); i++) {
			TextView x = (TextView) fragmentTabHost.getTabWidget()
					.getChildAt(i).findViewById(android.R.id.title);
			x.setTextSize(30);
			x.setTextColor(Color.rgb(183, 33, 3));
			x.setTypeface(typeFaceHead);
			fragmentTabHost.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.drawable.selector_main_tab);

		}
		// setting for tabwidget end

	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		try {
			ConnectivityManager conMgr = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

			State wifi = conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState(); // wifi
			if (wifi == NetworkInfo.State.CONNECTED|| wifi == NetworkInfo.State.CONNECTING) {
				Log.i("wifi Network Connect","Success");
				
			}
			State mobile = conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState(); // mobile
			if (mobile == NetworkInfo.State.CONNECTED|| mobile == NetworkInfo.State.CONNECTING) {
				Log.i("3g Network Connect","Success");
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			Log.i("wifi Network Connect","false");
		}
		// false
		Log.i("wifi Network Connect","false");
	}


	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		switch(v.getId()) {
		
		case R.id.btn_Setting : 
			Intent Goto_Setting = new Intent(MainFragmentActivity.this,
					SettingActivity.class);
			startActivity(Goto_Setting);
			break;
		case R.id.btn_Back :
			onBackPressed();
			break;
		}
		
		
	}
	
	

}
