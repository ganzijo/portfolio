package com.nuriapp.activity;

import org.apache.commons.lang3.StringUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nuriapp.activitiy.R;
import com.nuriapp.data.Config;
import com.nuriapp.utils.BackPressCloseSystem;

public class MainActivity extends Activity {

	private Button loginBtn;
	private Button logoutBtn;
	private Button configBtn;
	private Button directBtn;
	// ////////////////////////////////////////////////////////
	public static TextView loginTextView;
	// ////////////////////////////////////////////////////////
	public static EditText loginId;
	public static EditText loginPassword;
	// ////////////////////////////////////////////////////////
	public static String userId;
	public static String userPassword;
	// ////////////////////////////////////////////////////////
	private LinearLayout idLinear;
	private LinearLayout passwordLinear;
	private LinearLayout CheckBoxLinear;
	// ////////////////////////////////////////////////////////
	private CheckBox saveIdCheckbox;
	private CheckBox autoLoginCheckbox;
	// ////////////////////////////////////////////////////////
	private InputMethodManager imm; // keyboard hide or show
	private BackPressCloseSystem backPressCloseSystem;
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (Config.sharedPreferences.getBoolean(Config.AutoLoginEnabled, false)) {
			loginId.setText(Config.sharedPreferences.getString(Config.Id, ""));
			loginPassword.setText(Config.sharedPreferences.getString(Config.Pw,
					""));
			saveIdCheckbox.setChecked(true);
			autoLoginCheckbox.setChecked(true);
			loginTextView.setText("사용자 : " + loginId.getText());
			idLinear.setVisibility(View.GONE);
			passwordLinear.setVisibility(View.GONE);
			CheckBoxLinear.setVisibility(View.GONE);
			loginBtn.setVisibility(View.GONE);
			logoutBtn.setVisibility(View.VISIBLE);
			configBtn.setVisibility(View.VISIBLE);
			directBtn.setVisibility(View.VISIBLE);
			loginTextView.setVisibility(View.VISIBLE);
			Config.editor = Config.sharedPreferences.edit();
			Config.editor.putBoolean(Config.RadioBtnState1,
					false);
			Config.editor.putBoolean(Config.RadioBtnState2,
					false);
			Config.editor.putBoolean(Config.RadioBtnState3,
					false);
			Config.editor.putBoolean(Config.RadioBtnState4,
					false);
			Config.editor.putBoolean(Config.RadioBtnState5,
					false);
			Config.editor.putBoolean(Config.RadioBtnState6,
					false);
			Config.editor.putBoolean(Config.RadioBtnState7,
					false);
			Config.editor.putBoolean(Config.RadioBtnState8,
					false);
			Config.editor.putBoolean(Config.RadioBtnState9,
					false);
			Config.editor.putBoolean(Config.RadioBtnState10,
					false);
			Config.editor.putBoolean(Config.RadioBtnState11,
					false);
			Config.editor.putBoolean(Config.RadioBtnState12,
					false);
			Config.editor.putBoolean(Config.RadioBtnState13,
					false);
			Config.editor.putBoolean(Config.RadioBtnState14,
					false);
			Config.editor.putBoolean(Config.RadioBtnState15,
					false);
			Config.editor.putBoolean(Config.RadioBtnState16,
					false);
			Config.editor.putBoolean(Config.RadioBtnState17,
					false);
			Config.editor.putBoolean(Config.RadioBtnState18,
					false);
			Config.editor.putBoolean(Config.Address,
					false);
			Config.editor.putBoolean(Config.Si, false);
			Config.editor.putBoolean(Config.Gu, false);
			Config.editor.putBoolean(Config.Dong, false);
			Config.editor.putBoolean(Config.Area, false);
			Config.editor.commit();
			
			
			String buildingState = Config.sharedPreferences.getString(Config.Building, "");
			if(autoLoginCheckbox.isChecked()&& buildingState != "currentBuilding"){
				Config.getInstance().setBuildingID(buildingState);
				Intent intent = new Intent(MainActivity.this, DetailInfo.class);
				startActivity(intent);
			}
			
		} else if (Config.sharedPreferences.getBoolean(Config.SaveIdEnabled,
				false)) {
			loginId.setText(Config.sharedPreferences.getString(Config.Id, ""));
			saveIdCheckbox.setChecked(true);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		final AlertDialog.Builder alert = new AlertDialog.Builder(
				MainActivity.this);
		backPressCloseSystem = new BackPressCloseSystem(this);
        // 뒤로 가기 버튼 이벤트
		Config.sharedPreferences = getSharedPreferences(Config.StatesPref,
				MODE_PRIVATE);
		
		
		
		
		// /////////////////////////////////////////////////////////
		loginBtn = (Button) findViewById(R.id.LoginBtn);
		logoutBtn = (Button) findViewById(R.id.LogoutBtn);
		configBtn = (Button) findViewById(R.id.ConfigBtn);
		directBtn = (Button) findViewById(R.id.DirectBtn);
		//
		loginTextView = (TextView) findViewById(R.id.LoginTV);
		//
		loginId = (EditText) findViewById(R.id.LoginID);
		loginPassword = (EditText) findViewById(R.id.LoginPW);
		//
		idLinear = (LinearLayout) findViewById(R.id.IDLinear);
		passwordLinear = (LinearLayout) findViewById(R.id.PWLinear);
		CheckBoxLinear = (LinearLayout) findViewById(R.id.CheckBoxLinear);
		//
		saveIdCheckbox = (CheckBox) findViewById(R.id.SaveIdChk);
		autoLoginCheckbox = (CheckBox) findViewById(R.id.AutoLoginChk);
		//
		loginTextView.setVisibility(View.GONE);
		logoutBtn.setVisibility(View.INVISIBLE);
		configBtn.setVisibility(View.INVISIBLE);
		directBtn.setVisibility(View.INVISIBLE);

		saveIdCheckbox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked) {
							Config.editor = Config.sharedPreferences.edit();
							Config.editor.putBoolean(Config.SaveIdEnabled,
									isChecked);
							Config.editor.putString(Config.Id, userId);
							Config.editor.commit();
						} else {
							Config.editor = Config.sharedPreferences.edit();
							Config.editor.putBoolean(Config.SaveIdEnabled,
									isChecked);
							Config.editor.putString(Config.Id, "");
							Config.editor.commit();
						}

					}
				});

		autoLoginCheckbox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked) {
							Config.editor = Config.sharedPreferences.edit();
							Config.editor.putString(Config.Id, userId);
							Config.editor.putString(Config.Pw, userPassword);
							Config.editor.putBoolean(Config.SaveIdEnabled,
									isChecked);
							Config.editor.putBoolean(Config.AutoLoginEnabled,
									isChecked);
							Config.editor.commit();
						} else {
							Config.editor = Config.sharedPreferences.edit();
							Config.editor.putString(Config.Id, "");
							Config.editor.putString(Config.Pw, "");
							Config.editor.putBoolean(Config.SaveIdEnabled,
									isChecked);
							Config.editor.putBoolean(Config.AutoLoginEnabled,
									isChecked);
							Config.editor.commit();
						}

					}
				});

		loginBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				userId = loginId.getText().toString();
				userPassword = loginPassword.getText().toString();

				if (userId.equals("admin") && userPassword.equals("1")) {
					Toast.makeText(getApplicationContext(), "Login Success",
							Toast.LENGTH_LONG).show();
					Config.getInstance().setCurrentUserId(userId);
					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("로그인 성공");
					alert.show();

					if (autoLoginCheckbox.isChecked()) {
						Config.editor = Config.sharedPreferences.edit();
						Config.editor.putString(Config.Id, userId);
						Config.editor.putString(Config.Pw, userPassword);
						Config.editor.commit();
					} else if (saveIdCheckbox.isChecked()) {
						Config.editor = Config.sharedPreferences.edit();
						Config.editor.putString(Config.Id, userId);
						Config.editor.commit();
					}
					loginTextView.setText("사용자 : " + userId);

					idLinear.setVisibility(View.GONE);
					passwordLinear.setVisibility(View.GONE);
					CheckBoxLinear.setVisibility(View.GONE);
					loginBtn.setVisibility(View.GONE);
					logoutBtn.setVisibility(View.VISIBLE);
					configBtn.setVisibility(View.VISIBLE);
					directBtn.setVisibility(View.VISIBLE);
					loginTextView.setVisibility(View.VISIBLE);

				} else if (userId.equals("")) {
					Toast.makeText(getApplicationContext(), "아이디를 입력하세요.",
							Toast.LENGTH_LONG).show();
					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("아이디를 입력하세요.");
					alert.show();
				} else if (userPassword.equals("")) {
					Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.",
							Toast.LENGTH_LONG).show();

					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("비밀번호를 입력하세요.");
					alert.show();

				} else if (userId != "admin" && userPassword.equals("1")) {
					Toast.makeText(getApplicationContext(), "존재하지 않는 아이디 입니다.",
							Toast.LENGTH_LONG).show();

					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("존재하지 않는 아이디입니다.");
					alert.show();

				} else if (userId.equals("admin") && userPassword != "1") {
					Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.",
							Toast.LENGTH_LONG).show();

					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("비밀번호가 일치하지 않습니다.");
					alert.show();

				} else {

					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("잘못입력하셨습니다.");
					alert.show();
				}

				imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);
			}
		});

		logoutBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Logout",
						Toast.LENGTH_LONG).show();
				logoutBtn.setVisibility(View.INVISIBLE);
				configBtn.setVisibility(View.INVISIBLE);
				directBtn.setVisibility(View.INVISIBLE);
				loginBtn.setVisibility(View.VISIBLE);
				idLinear.setVisibility(View.VISIBLE);
				passwordLinear.setVisibility(View.VISIBLE);
				CheckBoxLinear.setVisibility(View.VISIBLE);
				loginTextView.setVisibility(View.GONE);
			}
		});

		configBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Settings.class);
				startActivity(intent);
			}
		});

		directBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						BuildingList.class);
				startActivity(intent);
			}
		});
		

	}
	
	@Override
	public void onBackPressed() {
		backPressCloseSystem.onBackPressed();
	}
}
