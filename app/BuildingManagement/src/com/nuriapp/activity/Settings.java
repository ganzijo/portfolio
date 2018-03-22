package com.nuriapp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.nuriapp.activitiy.R;
import com.nuriapp.data.Config;

public class Settings extends Activity {
	private ToggleButton autoLoginToggleBtn;
	private TextView anotherIdLogin, interestBuildingSettings, currentLoginId;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Config.sharedPreferences = getSharedPreferences(Config.StatesPref, MODE_PRIVATE);
		
		autoLoginToggleBtn
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked) {
							Config.getInstance().setCurrentAutoLoginEnabled(
									isChecked);
							Config.editor = Config.sharedPreferences.edit();
							Config.editor.putBoolean(Config.AutoLoginEnabled, isChecked);
							Config.editor.putBoolean(Config.SaveIdEnabled, isChecked);
							Config.editor.putString(Config.Id, MainActivity.loginId.getText().toString());
							Config.editor.putString(Config.Pw, MainActivity.loginPassword.getText().toString());
							MainActivity.loginTextView.setText("사용자 : "+ MainActivity.loginId.getText());
							Config.editor.commit();
						} else {
							Config.getInstance().setCurrentAutoLoginEnabled(
									isChecked);
							Config.editor = Config.sharedPreferences.edit();
							Config.editor.putBoolean(Config.AutoLoginEnabled, isChecked);
							Config.editor.putBoolean(Config.SaveIdEnabled, isChecked);
							Config.editor.commit();
						}
					}
				});

		
		
		
		anotherIdLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Config.getInstance().setCurrentUserId("");// Id 초기
				Config.sharedPreferences = getSharedPreferences(Config.StatesPref, MODE_PRIVATE);
				Config.editor = Config.sharedPreferences.edit();
				Config.editor.clear();
				Config.editor.commit();
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});

		interestBuildingSettings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Settings.this, BuildingList.class);
				startActivity(intent);
			}
		});

		currentLoginId.setText(MainActivity.loginId.getText());

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		autoLoginToggleBtn = (ToggleButton) findViewById(R.id.AutoLoginToggleBtn);
		anotherIdLogin = (TextView) findViewById(R.id.AnotherIdLogin);
		interestBuildingSettings = (TextView) findViewById(R.id.InterestBuildingSettings);
		currentLoginId = (TextView) findViewById(R.id.CurrentLoginId);
		
		
		if(Config.sharedPreferences.getBoolean(Config.AutoLoginEnabled, false)){
			autoLoginToggleBtn.setChecked(true);
		}else{
			autoLoginToggleBtn.setChecked(false);
		}
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
			Config.sharedPreferences = getSharedPreferences(Config.StatesPref, MODE_PRIVATE);
			Config.editor = Config.sharedPreferences.edit();
			Config.editor.putString(Config.Id, MainActivity.userId);
			MainActivity.loginTextView.setText("사용자 : "+ MainActivity.loginId.getText());
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
