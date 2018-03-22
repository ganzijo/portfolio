package com.nuriapp.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost.OnTabChangeListener;

import com.nuriapp.activitiy.R;
import com.nuriapp.data.Config;

public class DetailInfo extends FragmentActivity implements TabListener {
	private Spinner spinner;
	private int currentTab = 0;
	public FragmentTabHost fragmentTabHost;
	private Button backBtn;
	public static final String SELECT_ITEM = "selectItem";
	public static Context con;
	public static View view;
	Fragment fragment;
	private ProgressDialog dialog;
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (Config.getInstance().getBuildingID().equals("1")) {
			spinner.setSelection(0);
			fragment = getSupportFragmentManager().findFragmentByTag(
					"Electricity");
		}
		if (Config.getInstance().getBuildingID().equals("2")) {
			spinner.setSelection(1);
		}
		if (Config.getInstance().getBuildingID().equals("3")) {
			spinner.setSelection(2);
		}

	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailinfo);
		// ActionBar Settings Start
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		actionBar.setIcon(R.drawable.ic_action_settings);
		// ActionBar Settings End
		backBtn = (Button) findViewById(R.id.BackBtn);
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});

		spinner = (Spinner) findViewById(R.id.BuildingName_Prompt);
		@SuppressWarnings("rawtypes")
		ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.BuildingNameList, android.R.layout.simple_spinner_item);
		spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinnerAdapter);

		fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		fragmentTabHost.setup(this, getSupportFragmentManager(),
				android.R.id.tabcontent);
		fragmentTabHost.addTab(fragmentTabHost.newTabSpec("EnergyTab")
				.setIndicator("에너지사용현황"), DetailEnergy.class, null);
		fragmentTabHost.addTab(fragmentTabHost.newTabSpec("ElectricityTab")
				.setIndicator("전기소비현황"), DetailElectricity.class, null);
		fragmentTabHost.addTab(fragmentTabHost.newTabSpec("GasTab")
				.setIndicator("가스소비현황"), DetailGas.class, null);
		fragmentTabHost.addTab(fragmentTabHost.newTabSpec("WaterTab")
				.setIndicator("수도소비현황"), DetailWater.class, null);

		setCurrentTab(fragmentTabHost.getCurrentTab());
		
		fragmentTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				final AlertDialog.Builder dialog = new AlertDialog.Builder(DetailInfo.this).setTitle("페이지 이동중").setMessage("잠시만 기다리세요...");
			
				final AlertDialog alert = dialog.create();
				alert.show();

				// Hide after some seconds
				final Handler handler  = new Handler();
				final Runnable runnable = new Runnable() {
				    @Override
				    public void run() {
				        if (alert.isShowing()) {
				            alert.dismiss();
				        }
				    }
				};

				alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
				    @Override
				    public void onDismiss(DialogInterface dialog) {
				        handler.removeCallbacks(runnable);
				    }
				});

				handler.postDelayed(runnable, 1000);
			}
		});
		

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Config config = Config.getInstance();
				// TODO Auto-generated method stub
				if (spinner.getSelectedItem().toString().equals("ETRI빌딩")) {
					config.setBuildingID("1");
				} else if (spinner.getSelectedItem().toString().equals("누리빌딩")) {
					config.setBuildingID("2");

				} else if (spinner.getSelectedItem().toString().equals("삼성물산")) {
					config.setBuildingID("3");
				}
				Config.setInstance(config);
				Fragment flag = getSupportFragmentManager().findFragmentByTag(
						fragmentTabHost.getCurrentTabTag());
				if (flag != null)
					flag.onStart();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
		con = this;

	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub


	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	public int getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(int currentTab) {
		this.currentTab = currentTab;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.action_home) {
			Intent intent = new Intent(this, DetailInfo.class);
			Config.sharedPreferences = getSharedPreferences(Config.StatesPref,
					MODE_PRIVATE);
			Config.editor = Config.sharedPreferences.edit();
			Config.editor.putString(Config.Id, MainActivity.userId);
			MainActivity.loginTextView.setText("사용자 : "
					+ MainActivity.loginId.getText());
			Config.editor.commit();
			startActivity(intent);
			return true;
		}
		if (itemId == R.id.action_settingicon) {
			Intent intent = new Intent(this, Settings.class);
			Config.sharedPreferences = getSharedPreferences(Config.StatesPref,
					MODE_PRIVATE);
			Config.editor = Config.sharedPreferences.edit();
			Config.editor.putString(Config.Id, MainActivity.userId);
			MainActivity.loginTextView.setText("사용자 : "
					+ MainActivity.loginId.getText());
			Config.editor.commit();
			startActivity(intent);
			return true;
		}
		return (super.onOptionsItemSelected(item));
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK :
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
}
